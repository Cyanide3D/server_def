package com.defiant.server.repository;

import com.defiant.server.model.Wire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WireRepo extends JpaRepository<Wire, Long> {
}
