package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.AEOCategory;
import com.urjanet.energy.repository.AEOCategoryRepository;

@Service
public class AEOCategoryImpl extends GenericCategoryImpl<AEOCategory, AEOCategoryRepository>
		implements AEOCategoryService {

	@Autowired
	public AEOCategoryImpl(AEOCategoryRepository repository) {
		super(repository);
	}
}