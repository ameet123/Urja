package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.AEOCategory;

public interface AEOCategoryRepository extends GenericCategoryRepository<AEOCategory>,
		JpaRepository<AEOCategory, Long> {
}