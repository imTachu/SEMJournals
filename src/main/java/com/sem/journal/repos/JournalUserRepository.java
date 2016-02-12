package com.sem.journal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sem.journal.model.JournalUser;

public interface JournalUserRepository extends CrudRepository<JournalUser, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public JournalUser save(JournalUser s);

	List<JournalUser> findAll();
	
	@Override
	JournalUser findOne(Integer integer);

	@Query(value = "select s from JournalUser s where s.email = :email ")
	JournalUser findJournalUserByEmail(@Param("email") String email);

}
