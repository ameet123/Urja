package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.NgSeries;

public interface NgSeriesRepository extends GenericRepository<NgSeries>,
		JpaRepository<NgSeries, Long> {
}