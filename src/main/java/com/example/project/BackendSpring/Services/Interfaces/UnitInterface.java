package com.example.project.BackendSpring.Services.Interfaces;

import com.example.project.BackendSpring.Dtos.UnitDto;
import com.example.project.BackendSpring.Models.Unit;
import com.example.project.BackendSpring.Utilities.TemplateApi;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface UnitInterface {
    TemplateApi UpdateUnit(UnitDto unitDto, UUID idUserCurrent, String fullName);
    TemplateApi InsertUnit(UnitDto unitDto, UUID idUserCurrent, String fullName);
    TemplateApi GetAllUnit(int pageNumber, int pageSize);
    TemplateApi GetUnitById(UUID IdUnit);
    TemplateApi DeleteUnit(UUID IdUnit, UUID IdUserCurrent, String fullName);
    Unit GetUnitByUnitCode(String unitCode);
}
