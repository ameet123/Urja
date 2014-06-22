package com.urjanet.energy.service;

import java.util.List;

import com.urjanet.energy.entity.UtilityCompanies;

public interface UtilityCompaniesService {
	
	UtilityCompanies save(UtilityCompanies created);

	void delete(Long id);
	
	List<UtilityCompanies> findAll();
	
	long getCount();
}
