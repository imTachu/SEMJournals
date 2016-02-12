package com.sem.journal.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sem.journal.model.Subscription;
import com.sem.journal.services.SubscriptionService;
import com.sem.journal.util.ServiceResult;

@RestController
@RequestMapping(value = "/rest")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	@RequestMapping(value = "/subscription/{journalUser}/{journal}", method = RequestMethod.PUT)
	public ServiceResult addSubscription(@PathVariable("journalUser") Integer journalUser,
            @PathVariable("journal")Integer journal) {
		ServiceResult serviceResult = new ServiceResult();
		Subscription subscription = new Subscription();
		subscription = subscriptionService.addSubscription(journalUser, journal);
		serviceResult.setResult(subscription);
		return serviceResult;
	}
	
	@RequestMapping(value = "/subscription/{journalUser}", method = RequestMethod.GET)
	public ServiceResult getSubscriptionsByJournalUserId(HttpServletResponse res,
			@PathVariable("journalUser") Integer journalUser) {
		ServiceResult ro = new ServiceResult();
		List<Subscription> subscriptions = subscriptionService.getSubscriptionsByJournalUserId(journalUser);
		ro.setResult(subscriptions);
		ro.setCheckMessage("This is the serviceResult!");
		ro.setTotalObjects(subscriptions.size());
		return ro;
	}
	
}