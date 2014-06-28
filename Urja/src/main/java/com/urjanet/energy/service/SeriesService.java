package com.urjanet.energy.service;

import java.util.List;

import com.urjanet.energy.entity.Series;

public interface SeriesService {
	
	Series save(Series created);

	void delete(Long id);
	
	List<Series> findAll();
	
	long getCount();
}
