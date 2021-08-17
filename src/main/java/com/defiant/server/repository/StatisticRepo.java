package com.defiant.server.repository;

import com.defiant.server.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepo extends JpaRepository<Statistic, Long> {
}
