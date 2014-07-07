package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.CoalSeries;
import com.urjanet.energy.repository.CoalSeriesRepository;

@Service
public class CoalSeriesImpl extends GenericImpl<CoalSeries, CoalSeriesRepository>
		implements CoalService {

	@Autowired
	public CoalSeriesImpl(CoalSeriesRepository repository) {
		super(repository);
	}
}