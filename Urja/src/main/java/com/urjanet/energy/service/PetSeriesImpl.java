package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.PetSeries;
import com.urjanet.energy.repository.PetSeriesRepository;

@Service
public class PetSeriesImpl extends GenericImpl<PetSeries, PetSeriesRepository>
		implements PetService {

	@Autowired
	public PetSeriesImpl(PetSeriesRepository repository) {
		super(repository);
	}
}