package com.example.project.BackendSpring.Services.Implement;

import com.example.project.BackendSpring.Dtos.UnitDto;
import com.example.project.BackendSpring.Models.Diary;
import com.example.project.BackendSpring.Models.Unit;
import com.example.project.BackendSpring.Repositories.DiaryRepository;
import com.example.project.BackendSpring.Repositories.UnitRepository;
import com.example.project.BackendSpring.Services.Interfaces.UnitInterface;
import com.example.project.BackendSpring.Utilities.SaveToDiary;
import com.example.project.BackendSpring.Utilities.TemplateApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UnitService implements UnitInterface {
    @Autowired
    UnitRepository unitRepository;

    @Autowired
    DiaryRepository diaryRepository;

    private static final Logger logger = LoggerFactory.getLogger(UnitService.class);

    @Override
    public TemplateApi UpdateUnit(UnitDto unitDto, UUID idUserCurrent, String fullName) {

        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        Unit unit = unitRepository.findById(unitDto.getId()).orElse(null);
        if (unit == null) return new TemplateApi("Không tìm thấy phòng ban", false, true);

        unit.setUnitname(unitDto.getUnitcode());
        unitRepository.save(unit);
        diaries.add(saveToDiary.InsertDiary("Update", idUserCurrent, unitDto.getId(), fullName, "Unit", ""));

        diaryRepository.saveAll(diaries);

        return new TemplateApi("Cập nhật thành công", true, false);
    }

    @Override
    public TemplateApi InsertUnit(UnitDto unitDto, UUID idUserCurrent, String fullName) {

        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        Unit unit = new Unit();
        BeanUtils.copyProperties(unitDto, unit);

        unitRepository.save(unit);
        diaries.add(saveToDiary.InsertDiary("Create", idUserCurrent, unitDto.getId(), fullName, "Unit", ""));

        diaryRepository.saveAll(diaries);

        return new TemplateApi("Thêm mới thành công", true, false);
    }

    @Override
    public TemplateApi GetAllUnit(int pageNumber, int pageSize) {
        List<Unit> units = unitRepository.findAll();

        int countRecord = units.size();

        if (pageNumber != 0 && pageSize != 0) {
            if (pageNumber < 0) {
                pageNumber = 1;
            }
            units = units.subList((pageNumber - 1) * pageSize, pageSize);
        }

        int NumPageSize = pageSize == 0 ? 1 : pageSize;
        logger.info("Lấy danh sách thành công !");
        return new TemplateApi(null, units.toArray(new Unit[0]), "Lấy danh sách thành công", true, false, pageNumber, pageSize, countRecord, NumPageSize);
    }

    @Override
    public TemplateApi GetUnitById(UUID IdUnit) {
        Unit unit = unitRepository.findById(IdUnit).orElse(null);
        if (unit == null) return new TemplateApi("Không tìm thấy phòng ban", false, true);
        return new TemplateApi(unit, null, "Lấy thông tin đơn vị thành công", true, false, 0, 0, 1, 0);
    }

    @Override
    public TemplateApi DeleteUnit(UUID IdUnit, UUID IdUserCurrent, String fullName) {
        List<Diary> diaries = new ArrayList<>();
        var saveToDiary = new SaveToDiary();

        Unit unit = unitRepository.findById(IdUnit).orElse(null);
        if (unit == null) return new TemplateApi("Không tìm thấy phòng ban", false, true);

        unitRepository.deleteById(IdUnit);
        diaries.add(saveToDiary.InsertDiary("Create", IdUserCurrent, IdUnit, fullName, "Unit", ""));

        diaryRepository.saveAll(diaries);

        logger.info("Xóa thành công phòng ban");
        return new TemplateApi("Xóa thành công", true, false);
    }
}
