package com.sem.journal.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sem.journal.model.Volume;

public interface VolumeRepository extends CrudRepository<Volume, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public Volume save(Volume s);

	List<Volume> findAll();
	
	@Override
	Volume findOne(Integer integer);
	
}
