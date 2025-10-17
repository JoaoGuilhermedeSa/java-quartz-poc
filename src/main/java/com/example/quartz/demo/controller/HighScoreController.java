package com.example.quartz.demo.controller;

import com.example.quartz.demo.domain.HighScore;
import com.example.quartz.demo.repository.HighScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HighScoreController {

    @Autowired
    private HighScoreRepository highScoreRepository;

    @GetMapping("/highscores")
    public List<HighScore> listHighScores() {
        return highScoreRepository.findAll();
    }
}
