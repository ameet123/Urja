package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.PetSeries;

public interface PetSeriesRepository extends GenericRepository<PetSeries>,
		JpaRepository<PetSeries, Long> {
}