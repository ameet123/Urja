package com.urjanet.energy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urjanet.energy.entity.PetCategory;
import com.urjanet.energy.repository.PetCategoryRepository;

@Service
public class PetCategoryImpl extends GenericCategoryImpl<PetCategory, PetCategoryRepository>
		implements PetCategoryService {

	@Autowired
	public PetCategoryImpl(PetCategoryRepository repository) {
		super(repository);
	}
}