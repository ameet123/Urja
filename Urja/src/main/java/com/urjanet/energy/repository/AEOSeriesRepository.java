package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.AEOSeries;

public interface AEOSeriesRepository extends GenericRepository<AEOSeries>,
		JpaRepository<AEOSeries, Long> {
}