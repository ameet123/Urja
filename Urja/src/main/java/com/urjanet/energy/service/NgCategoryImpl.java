package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.NgCategory;
import com.urjanet.energy.repository.NgCategoryRepository;

@Service
public class NgCategoryImpl extends GenericCategoryImpl<NgCategory, NgCategoryRepository>
		implements NgCategoryService {

	@Autowired
	public NgCategoryImpl(NgCategoryRepository repository) {
		super(repository);
	}
}