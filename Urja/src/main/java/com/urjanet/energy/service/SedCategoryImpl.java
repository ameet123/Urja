package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.SedCategory;
import com.urjanet.energy.repository.SedCategoryRepository;

@Service
public class SedCategoryImpl extends GenericCategoryImpl<SedCategory, SedCategoryRepository>
		implements SedCategoryService {

	@Autowired
	public SedCategoryImpl(SedCategoryRepository repository) {
		super(repository);
	}
}