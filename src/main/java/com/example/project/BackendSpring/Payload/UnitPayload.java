package com.example.project.BackendSpring.Payload;

import java.util.UUID;

public class UnitPayload {
    private String UnitName;
    private String UnitCode;
    private UUID ParentId;

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getUnitCode() {
        return UnitCode;
    }

    public void setUnitCode(String unitCode) {
        UnitCode = unitCode;
    }

    public UUID getParentId() {
        return ParentId;
    }

    public void setParentId(UUID parentId) {
        ParentId = parentId;
    }
}
