package com.urjanet.energy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.SedsSeries;
import com.urjanet.energy.repository.SedsSeriesRepository;

@Service
public class SedsSeriesImpl implements SedsSeriesService {
	private SedsSeriesRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(SedsSeriesImpl.class);
	
	@Autowired
	public SedsSeriesImpl(SedsSeriesRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public SedsSeries save(SedsSeries created) {
		LOGGER.debug("saving seds series: " + created.getName());
		try {
			repository.save(created);
			return created;
		} catch (Exception e) {
			LOGGER.error("error in saving series:{} error:{}",created.getName(), e.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.debug("Deleting seds series with ID:"+id);
		repository.delete(id);
		
	}

	@Override
	public List<SedsSeries> findAll() {
		return repository.findAll();
	}

	@Override
	public long getCount() {
		return repository.count();
	}
}