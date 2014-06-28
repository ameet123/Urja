package com.urjanet.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urjanet.energy.entity.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {}
