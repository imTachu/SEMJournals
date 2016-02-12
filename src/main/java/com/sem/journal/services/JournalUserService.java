package com.sem.journal.services;

import com.sem.journal.model.JournalUser;
import com.sem.journal.repos.JournalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lorena Salamanca
 *
 */
@Service
@Transactional
public class JournalUserService {

    @Autowired
    private JournalUserRepository journalUserRepository;

    public JournalUser createProfile(JournalUser user){
        return journalUserRepository.save(user);

    }
    
    public JournalUser findJournalUserByEmail(String email){
    	return journalUserRepository.findJournalUserByEmail(email);
    }

}