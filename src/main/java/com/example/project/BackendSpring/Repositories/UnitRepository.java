package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UnitRepository extends JpaRepository<Unit, UUID> {
}
