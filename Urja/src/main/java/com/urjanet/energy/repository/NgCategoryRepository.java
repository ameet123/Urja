package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.NgCategory;

public interface NgCategoryRepository extends GenericCategoryRepository<NgCategory>,
		JpaRepository<NgCategory, Long> {
}