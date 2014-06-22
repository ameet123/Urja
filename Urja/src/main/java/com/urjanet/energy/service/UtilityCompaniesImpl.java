package com.urjanet.energy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.UtilityCompanies;
import com.urjanet.energy.repository.UtilityCompaniesRepository;

@Service
public class UtilityCompaniesImpl implements UtilityCompaniesService {
	private UtilityCompaniesRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilityCompaniesImpl.class);
	
	@Autowired
	public UtilityCompaniesImpl(UtilityCompaniesRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public UtilityCompanies save(UtilityCompanies created) {
		LOGGER.debug("saving UtilityCompanies: " + created.getLabel());
		try {
			repository.save(created);
			return created;
		} catch (Exception e) {
			LOGGER.error("error in saving UtilityCompanies:{} error:{}",created.getLabel(), e.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.debug("Deleting UtilityCompanies with ID:"+id);
		repository.delete(id);
		
	}

	@Override
	public List<UtilityCompanies> findAll() {
		return repository.findAll();
	}

	@Override
	public long getCount() {
		return repository.count();
	}
}