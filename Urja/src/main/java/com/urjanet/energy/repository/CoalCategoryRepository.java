package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.CoalCategory;

public interface CoalCategoryRepository extends GenericCategoryRepository<CoalCategory>,
		JpaRepository<CoalCategory, Long> {
}