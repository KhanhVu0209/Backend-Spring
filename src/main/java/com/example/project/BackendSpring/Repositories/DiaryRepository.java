package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiaryRepository extends JpaRepository<Diary, UUID> {
}
