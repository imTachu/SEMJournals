package com.sem.journal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sem.journal.model.Journal;

public interface JournalRepository extends CrudRepository<Journal, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public Journal save(Journal s);

	List<Journal> findAll();
	
	@Override
	Journal findOne(Integer integer);
	
	@Query(value = "select s from Journal s where s.journalUser.id = :journalUser ")
	List<Journal> findJournalsByJournalUserId(@Param("journalUser") Integer journalUser);
	
}
