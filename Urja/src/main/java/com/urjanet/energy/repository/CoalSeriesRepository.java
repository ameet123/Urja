package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.CoalSeries;

public interface CoalSeriesRepository extends GenericRepository<CoalSeries>,
		JpaRepository<CoalSeries, Long> {
}