package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.AEOSeries;
import com.urjanet.energy.repository.AEOSeriesRepository;

@Service
public class AEOSeriesImpl extends GenericImpl<AEOSeries, AEOSeriesRepository>
		implements AEOService {

	@Autowired
	public AEOSeriesImpl(AEOSeriesRepository repository) {
		super(repository);
	}
}