package com.example.project.BackendSpring.Utilities;

import com.example.project.BackendSpring.Models.Diary;

import java.util.Date;
import java.util.UUID;

public class SaveToDiary {
    public Diary InsertDiary(String operation, UUID userId, UUID idWith, String fullName, String table, String content) {
        Diary diary = new Diary();

        diary.setId(UUID.randomUUID());
        diary.setDateCreate(new Date());
        diary.setUserId(userId);
        diary.setWithId(idWith);
        diary.setUserName(fullName);
        diary.setOperation(operation);
        diary.setSuccess(true);
        diary.setTable(table);
        diary.setContent(fullName + (operation.equals("Create") ? " đã thêm mới " : operation.equals("Update") ? " đã cập nhật " : " đã xóa ") + table + " - " + content);
        diary.setTitle((operation.equals("Create") ? "Thêm mới vào CSDL" : operation.equals("Update") ? "Cập nhật vào CSDL" : "Xóa thông tin CSDL"));
        return diary;
    }
}
