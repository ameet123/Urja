package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.CoalCategory;
import com.urjanet.energy.repository.CoalCategoryRepository;

@Service
public class CoalCategoryImpl extends GenericCategoryImpl<CoalCategory, CoalCategoryRepository>
		implements CoalCategoryService {

	@Autowired
	public CoalCategoryImpl(CoalCategoryRepository repository) {
		super(repository);
	}
}