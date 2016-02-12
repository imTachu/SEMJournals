package com.sem.journal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sem.journal.model.Journal;
import com.sem.journal.model.Volume;
import com.sem.journal.repos.JournalRepository;
import com.sem.journal.repos.VolumeRepository;

/**
 * @author Lorena Salamanca
 *
 */
@Service
@Transactional
public class VolumeService {

	@Autowired
	private VolumeRepository volumeRepository;
	
	@Autowired
	private JournalRepository journalRepository;

	public Volume addVolume(String name, String fileUrl, Integer journalId) {
		Integer id = null;
		Volume volume = new Volume();
		Volume entity = new Volume();
		Journal journal = journalRepository.findOne(journalId);
		volume.setId(id);
		volume.setName(name);
		volume.setFileUrl(fileUrl);
		volume.setJournal(journal);
		entity = volumeRepository.save(volume);

		return entity;

	}

}