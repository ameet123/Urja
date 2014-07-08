package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.SedSeries;

public interface SedSeriesRepository extends GenericRepository<SedSeries>,
		JpaRepository<SedSeries, Long> {
}