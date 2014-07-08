package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.NgSeries;
import com.urjanet.energy.repository.NgSeriesRepository;

@Service
public class NgSeriesImpl extends GenericImpl<NgSeries, NgSeriesRepository>
		implements NgService {

	@Autowired
	public NgSeriesImpl(NgSeriesRepository repository) {
		super(repository);
	}
}