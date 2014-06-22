package com.urjanet.energy.service;

import java.util.List;

import com.urjanet.energy.entity.UtilityRates;

public interface UtilityRatesService {
	
	UtilityRates save(UtilityRates created);

	void delete(Long id);
	
	List<UtilityRates> findAll();
	
	long getCount();
}
