package com.urjanet.energy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.UtilityRates;
import com.urjanet.energy.repository.UtilityRatesRepository;

@Service
public class UtilityRatesImpl implements UtilityRatesService {
	private UtilityRatesRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilityRatesImpl.class);
	
	@Autowired
	public UtilityRatesImpl(UtilityRatesRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public UtilityRates save(UtilityRates created) {
		LOGGER.debug("saving UtilityRates: " + created.getName());
		try {
			repository.save(created);
			return created;
		} catch (Exception e) {
			LOGGER.error("error in saving UTilityRates:{} error:{}",created.getLabel(), e.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.debug("Deleting Utility rate with ID:"+id);
		repository.delete(id);
		
	}

	@Override
	public List<UtilityRates> findAll() {
		return repository.findAll();
	}

	@Override
	public long getCount() {
		return repository.count();
	}
}