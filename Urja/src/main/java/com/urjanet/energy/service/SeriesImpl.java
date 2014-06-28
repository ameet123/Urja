package com.urjanet.energy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.Series;
import com.urjanet.energy.repository.SeriesRepository;

@Service
public class SeriesImpl implements SeriesService {
	private SeriesRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(SeriesImpl.class);
	
	@Autowired
	public SeriesImpl(SeriesRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public Series save(Series created) {
		LOGGER.debug("saving series: " + created.getName());
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
		LOGGER.debug("Deleting series with ID:"+id);
		repository.delete(id);
		
	}

	@Override
	public List<Series> findAll() {
		return repository.findAll();
	}

	@Override
	public long getCount() {
		return repository.count();
	}
}