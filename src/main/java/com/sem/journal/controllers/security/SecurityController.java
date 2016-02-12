package com.sem.journal.controllers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sem.journal.model.JournalUser;
import com.sem.journal.services.JournalUserService;
import com.sem.journal.util.ServiceResult;;

/**
 * Controlador encargado de validar el usuario que se encuentra actualmente 
 * logueado
 * 
 * @author Diego Agudelo
 */
@RestController
@RequestMapping(value="/rest")
public class SecurityController {

	/**
	 * Servicio spring utilizado para consultar la informacion del(los) usuario(s)
	 */
	@Autowired
    private JournalUserService journalUserService;
	
	/**
	 * Servicio que recibe un nombre de usuario 
	 * @param username
	 * @return user - la informacion del usuario solicitado
	 */	
	@RequestMapping(value="/loggedUser",method=RequestMethod.GET)
	public ServiceResult user(@RequestBody JournalUser user){
		ServiceResult serviceResult = new ServiceResult();
		JournalUser journalUser = journalUserService.findJournalUserByEmail(user.getEmail());
//		journalUser.setPassword(null);
		serviceResult.setResult(journalUser);
		return serviceResult;
	}
//	@RequestMapping(value="/loggedUser/{email}",method=RequestMethod.GET)
//	public ServiceResult user(@PathVariable String email){
//		ServiceResult serviceResult = new ServiceResult();
//		JournalUser journalUser = journalUserService.findJournalUserByEmail(email);
//		journalUser.setPassword(null);
//		serviceResult.setResult(journalUser);
//		return serviceResult;
//	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		return "SEM Journal API";
	}
	
}