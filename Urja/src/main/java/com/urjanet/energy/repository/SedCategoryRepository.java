package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.SedCategory;

public interface SedCategoryRepository extends GenericCategoryRepository<SedCategory>,
		JpaRepository<SedCategory, Long> {
}