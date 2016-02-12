package com.sem.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sem.journal.model.JournalUser;
import com.sem.journal.services.JournalUserService;
import com.sem.journal.util.ServiceResult;
import com.sem.journal.util.Status;
import com.sem.journal.util.enums.EResult;
import com.sem.journal.util.enums.EStatusType;

@RestController
@RequestMapping(value = "/rest")
public class JournalUserController {

	@Autowired
	private JournalUserService journalUserService;

	@RequestMapping(value = "/user/public", method = RequestMethod.POST)
	public ServiceResult createPublicProfile(@RequestBody JournalUser user) {
		ServiceResult resultado = new ServiceResult();
		if (user != null) {
			user.setPublisher(false);
			resultado.setResult(journalUserService.createProfile(user));
			resultado.setStatus(new Status(EStatusType.OK, EResult.SUCCESS_RESULT.getDescription()));
		} else {
			resultado.setStatus(new Status(EStatusType.ERROR, EResult.INVALID_PARAMS_RESULT.getDescription()));
		}
		return resultado;
	}
	
	@RequestMapping(value = "/user/publisher", method = RequestMethod.POST)
	public ServiceResult createPublisherProfile(@RequestBody JournalUser user) {
		ServiceResult resultado = new ServiceResult();
		if (user != null) {
			user.setPublisher(true);
			resultado.setResult(journalUserService.createProfile(user));
			resultado.setStatus(new Status(EStatusType.OK, EResult.SUCCESS_RESULT.getDescription()));
		} else {
			resultado.setStatus(new Status(EStatusType.ERROR, EResult.INVALID_PARAMS_RESULT.getDescription()));
		}
		return resultado;
	}

}