package com.sem.journal.services;

import com.sem.journal.model.Journal;
import com.sem.journal.model.JournalUser;
import com.sem.journal.repos.JournalRepository;
import com.sem.journal.repos.JournalUserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lorena Salamanca
 *
 */
@Service
@Transactional
public class JournalService {

	@Autowired
	private JournalRepository journalRepository;

	@Autowired
	private JournalUserRepository journalUserRepository;

	public List<Journal> getAllJournals() {
		return journalRepository.findAll();
	}

	public List<Journal> getJournalsByJournalUser(Integer journalUser) {
		return journalRepository.findJournalsByJournalUserId(journalUser);
	}

	public Journal addJournal(String name, Integer journalUser) {
		Integer id = null;
		Journal journal = new Journal();
		Journal entity = new Journal();
		JournalUser user = journalUserRepository.findOne(journalUser);
		journal.setId(id);
		journal.setName(name);
		journal.setJournalUser(user);
		entity = journalRepository.save(journal);

		return entity;

	}

}