package com.sem.journal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sem.journal.model.Journal;
import com.sem.journal.model.JournalUser;
import com.sem.journal.model.Subscription;
import com.sem.journal.repos.JournalRepository;
import com.sem.journal.repos.JournalUserRepository;
import com.sem.journal.repos.SubscriptionRepository;

/**
 * @author Lorena Salamanca
 *
 */
@Service
@Transactional
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private JournalRepository journalRepository;
	
	@Autowired
	private JournalUserRepository journalUserRepository;

	public Subscription addSubscription(Integer journalUserId, Integer journalId) {
		Integer id = null;
		Subscription volume = new Subscription();
		Subscription entity = new Subscription();
		Journal journal = journalRepository.findOne(journalId);
		JournalUser journalUser = journalUserRepository.findOne(journalUserId);
		volume.setId(id);
		volume.setJournalUser(journalUser);
		volume.setJournal(journal);
		entity = subscriptionRepository.save(volume);

		return entity;

	}
	
	public List<Subscription> getSubscriptionsByJournalUserId(Integer journalUserId){
		return subscriptionRepository.findSubscriptionsByJournalUserId(journalUserId);
	}

}