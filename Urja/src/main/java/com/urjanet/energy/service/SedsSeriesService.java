package com.urjanet.energy.service;

import java.util.List;

import com.urjanet.energy.entity.SedsSeries;

public interface SedsSeriesService {
	
	SedsSeries save(SedsSeries created);

	void delete(Long id);
	
	List<SedsSeries> findAll();
	
	long getCount();
}
