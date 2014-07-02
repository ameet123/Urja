package com.urjanet.energy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.AeoSeries;
import com.urjanet.energy.repository.AeoSeriesRepository;

@Service
public class AeoSeriesImpl implements AeoSeriesService {
	private AeoSeriesRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(AeoSeriesImpl.class);
	
	@Autowired
	public AeoSeriesImpl(AeoSeriesRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public AeoSeries save(AeoSeries created) {
		LOGGER.debug("saving aeo series: " + created.getName());
		try {
			repository.save(created);
			return created;
		} catch (Exception e) {
			LOGGER.error("error in saving aeo series:{} error:{}",created.getName(), e.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.debug("Deleting aeo series with ID:"+id);
		repository.delete(id);
		
	}

	@Override
	public List<AeoSeries> findAll() {
		return repository.findAll();
	}

	@Override
	public long getCount() {
		return repository.count();
	}
}