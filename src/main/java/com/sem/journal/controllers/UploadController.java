package com.sem.journal.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sem.journal.util.ServiceResult;


@RestController
@RequestMapping(value = "/rest")
public class UploadController {

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ServiceResult darClientes() {
		ServiceResult ro = new ServiceResult();

		ro.setCheckMessage("El archivo subio correctamente!");

		return ro;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ServiceResult handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		ServiceResult ro = new ServiceResult();

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
				stream.write(bytes);
				stream.close();
				ro.setCheckMessage("You successfully uploaded " + name + " into " + name);
			} catch (Exception e) {
				ro.setCheckMessage("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			ro.setCheckMessage("You failed to upload " + name + " because the file was empty.");
		}

		return ro;
	}

	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
	public ServiceResult handleMultipleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile[] files) {
		ServiceResult ro = new ServiceResult();

		if (files.length != 0) {
			try {
				for (MultipartFile file : files) {
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
					stream.write(bytes);
					stream.close();
				}
				ro.setCheckMessage("You successfully uploaded " + files.length + " files");
			} catch (Exception e) {
				ro.setCheckMessage("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			ro.setCheckMessage("You failed to upload " + name + " because the file was empty.");
		}

		return ro;
	}
}