package com.example.project.BackendSpring.Controllers;

import com.example.project.BackendSpring.Dtos.UnitDto;
import com.example.project.BackendSpring.Payload.UnitPayload;
import com.example.project.BackendSpring.Services.Implement.UnitService;
import com.example.project.BackendSpring.Utilities.TemplateApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UnitController {
    @Autowired
    UnitService unitService;

    @GetMapping("/units")
    private ResponseEntity<TemplateApi> getAllUnits(int pageNumber, int pageSize) {
        var results = unitService.GetAllUnit(pageNumber, pageSize);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/unit/{id}")
    private ResponseEntity<TemplateApi> getUnitById(@PathVariable(value = "id") UUID idUnit) {
        var result = unitService.GetUnitById(idUnit);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/unit")
    private ResponseEntity<TemplateApi> createUnit(UnitPayload unitPayload) {

        UUID idUserCurrent = UUID.randomUUID();
        String fullName = "";

        UnitDto unitDto = new UnitDto();
        unitDto.setId(UUID.randomUUID());
        unitDto.setUnitname(unitPayload.getUnitName());
        unitDto.setCreatedby(idUserCurrent);
        unitDto.setUnitcode(unitPayload.getUnitCode());
        unitDto.setParentid(unitPayload.getParentId());
        unitDto.setStatus(0);
        unitDto.setCreateddate(new Date());
        unitDto.setIshide(true);

        final TemplateApi templateApi = unitService.InsertUnit(unitDto, idUserCurrent, fullName);
        return ResponseEntity.ok(templateApi);
    }

    @PutMapping("/unit/{id}")
    private ResponseEntity<TemplateApi> updateUnit(@PathVariable(value = "id") UUID unitId, UnitPayload unitPayload) {

        UnitDto unitDto = new UnitDto();
        unitDto.setId(unitId);
        unitDto.setUnitname(unitPayload.getUnitName());
        unitDto.setUnitcode(unitPayload.getUnitCode());
        unitDto.setParentid(unitPayload.getParentId());

        UUID idUserCurrent = UUID.randomUUID();
        String fullName = "";

        final TemplateApi templateApi = unitService.UpdateUnit(unitDto, idUserCurrent, fullName);
        return ResponseEntity.ok(templateApi);
    }

    @DeleteMapping("/unit/{id}")
    private ResponseEntity<TemplateApi> deleteUnit(@PathVariable(value = "id") UUID unitId) {
        UUID idUserCurrent = UUID.randomUUID();
        String fullName = "";

        final TemplateApi templateApi = unitService.DeleteUnit(unitId, idUserCurrent, fullName);
        return ResponseEntity.ok(templateApi);
    }
}
