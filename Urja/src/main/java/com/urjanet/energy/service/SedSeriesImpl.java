package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.SedSeries;
import com.urjanet.energy.repository.SedSeriesRepository;

@Service
public class SedSeriesImpl extends GenericImpl<SedSeries, SedSeriesRepository>
		implements SedService {

	@Autowired
	public SedSeriesImpl(SedSeriesRepository repository) {
		super(repository);
	}
}