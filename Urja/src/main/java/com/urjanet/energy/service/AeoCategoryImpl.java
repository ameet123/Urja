package com.urjanet.energy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.AeoCategory;
import com.urjanet.energy.repository.AeoCategoryRepository;

@Service
public class AeoCategoryImpl implements AeoCategoryService {
	private AeoCategoryRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(AeoCategoryImpl.class);
	
	@Autowired
	public AeoCategoryImpl(AeoCategoryRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public AeoCategory save(AeoCategory created) {
		LOGGER.debug("saving AEO category: " + created.getName());
		try {
			repository.save(created);
			return created;
		} catch (Exception e) {
			LOGGER.error("error in saving AEO category:{} error:{}",created.getName(), e.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.debug("Deleting aeo category with ID:"+id);
		repository.delete(id);
		
	}

	@Override
	public List<AeoCategory> findAll() {
		return repository.findAll();
	}

	@Override
	public long getCount() {
		return repository.count();
	}
}