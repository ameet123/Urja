package com.urjanet.energy.service;

import java.util.List;

import com.urjanet.energy.entity.AeoCategory;

public interface AeoCategoryService {
	
	AeoCategory save(AeoCategory created);

	void delete(Long id);
	
	List<AeoCategory> findAll();
	
	long getCount();
}
