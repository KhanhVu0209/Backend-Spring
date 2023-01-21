package com.example.project.BackendSpring.Utilities;

import com.example.project.BackendSpring.Models.Diary;

import java.util.Date;
import java.util.UUID;

public class SaveToDiary {
    public Diary InsertDiary(String operation, UUID userId, UUID idWith, String fullName, String table, String content) {
        Diary diary = new Diary();

        diary.setId(UUID.randomUUID());
        diary.setDatecreate(new Date());
        diary.setUserid(userId);
        diary.setWithid(idWith);
        diary.setUsername(fullName);
        diary.setOperation(operation);
        diary.setIssuccess(true);
        diary.setTableregardto(table);
        diary.setContentdiary(fullName + (operation.equals("Create") ? " đã thêm mới " : operation.equals("Update") ? " đã cập nhật " : " đã xóa ") + table + " - " + content);
        diary.setTitle((operation.equals("Create") ? "Thêm mới vào CSDL" : operation.equals("Update") ? "Cập nhật vào CSDL" : "Xóa thông tin CSDL"));
        return diary;
    }
}
