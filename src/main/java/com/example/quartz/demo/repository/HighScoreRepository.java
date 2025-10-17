package com.example.quartz.demo.repository;

import com.example.quartz.demo.domain.HighScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighScoreRepository extends JpaRepository<HighScore, Long> {
}
