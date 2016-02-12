package com.sem.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sem.journal.model.Volume;
import com.sem.journal.services.VolumeService;
import com.sem.journal.util.SecurityConstants;
import com.sem.journal.util.ServiceResult;

@RestController
@RequestMapping(value = "/rest")
public class VolumeController {

	@Autowired
	private VolumeService volumeService;

	@Secured(SecurityConstants.ROLE_PUBLISHER)
	@RequestMapping(value = "/volume/{name}/{fileUrl}/{journal}", method = RequestMethod.PUT)
	public ServiceResult addVolume(@PathVariable("name") String name,
            @PathVariable("fileUrl")String fileUrl,
            @PathVariable("journal") Integer journal) {
		ServiceResult serviceResult = new ServiceResult();
		Volume volume = new Volume();
		volume = volumeService.addVolume(name, fileUrl, journal);
		serviceResult.setResult(volume);
		return serviceResult;
	}
}