package com.urjanet.energy.service;

import java.util.List;

import com.urjanet.energy.entity.Category;

public interface CategoryService {
	
	Category save(Category created);

	void delete(Long id);
	
	List<Category> findAll();
	
	long getCount();
}
