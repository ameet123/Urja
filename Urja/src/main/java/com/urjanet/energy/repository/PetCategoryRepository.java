package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.PetCategory;

public interface PetCategoryRepository extends GenericCategoryRepository<PetCategory>,
		JpaRepository<PetCategory, Long> {
}