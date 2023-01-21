package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnitRepository extends JpaRepository<Unit, UUID> {
    @Query(value = "select *from [dbo].[Unit] where UnitCode = :unitCode", nativeQuery = true)
    Unit getUnitByUnitCode(String unitCode);
}
