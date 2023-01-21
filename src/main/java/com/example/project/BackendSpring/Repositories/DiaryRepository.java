package com.example.project.BackendSpring.Repositories;

import com.example.project.BackendSpring.Models.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, UUID> {
}
