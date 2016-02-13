package com.sem.journal.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sem.journal.model.Journal;
import com.sem.journal.services.JournalService;
import com.sem.journal.util.SecurityConstants;
import com.sem.journal.util.ServiceResult;

@RestController
@RequestMapping(value = "/rest")
public class JournalController {

	private static Logger LOG = Logger.getLogger(JournalService.class);
	
	@Autowired
	private JournalService journalService;

	@RequestMapping(value = "/journals", method = RequestMethod.GET)
	public ServiceResult getAllJournals(HttpServletResponse res) {
		LOG.info("JournalController#getAllJournals");
		ServiceResult ro = new ServiceResult();
		List<Journal> journals = journalService.getAllJournals();
		LOG.info("JournalController#getAllJournals2");
		ro.setResult(journals);
		ro.setCheckMessage("This is the serviceResult!");
		ro.setTotalObjects(journals.size());
		return ro;
	}
	
	@Secured(SecurityConstants.ROLE_PUBLISHER)
	@RequestMapping(value = "/journal/{journalUser}", method = RequestMethod.GET)
	public ServiceResult getJournalsByUser(HttpServletResponse res,
			@PathVariable("journalUser") Integer journalUser) {
		ServiceResult ro = new ServiceResult();
		List<Journal> journals = journalService.getJournalsByJournalUser(journalUser);
		ro.setResult(journals);
		ro.setCheckMessage("This is the serviceResult!");
		ro.setTotalObjects(journals.size());
		return ro;
	}

	@Secured(SecurityConstants.ROLE_PUBLISHER)
	@RequestMapping(value = "/journal/{name}/{journalUser}", method = RequestMethod.PUT)
	public ServiceResult addJournal(@PathVariable("name") String name,
			@PathVariable("journalUser") Integer journalUser) {
		ServiceResult serviceResult = new ServiceResult();
		Journal journal = new Journal();
		journal = journalService.addJournal(name, journalUser);
		serviceResult.setResult(journal);
		return serviceResult;
	}
}