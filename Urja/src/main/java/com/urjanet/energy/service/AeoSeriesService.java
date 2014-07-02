package com.urjanet.energy.service;

import java.util.List;

import com.urjanet.energy.entity.AeoSeries;

public interface AeoSeriesService {
	
	AeoSeries save(AeoSeries created);

	void delete(Long id);
	
	List<AeoSeries> findAll();
	
	long getCount();
}
