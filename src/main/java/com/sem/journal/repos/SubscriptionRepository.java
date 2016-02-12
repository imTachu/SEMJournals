package com.sem.journal.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sem.journal.model.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public Subscription save(Subscription s);

	List<Subscription> findAll();
	
	@Override
	Subscription findOne(Integer integer);

	@Query(value = "select s from Subscription s where s.journalUser.id = :journalUser ")
	List<Subscription> findSubscriptionsByJournalUserId(@Param("journalUser") Integer journalUser);
	
}
