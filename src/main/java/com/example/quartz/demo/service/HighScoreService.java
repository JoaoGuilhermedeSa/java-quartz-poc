package com.example.quartz.demo.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.quartz.demo.domain.HighScore;
import com.example.quartz.demo.domain.RpgCharacter;
import com.example.quartz.demo.domain.RpgCharacterHighScore;
import com.example.quartz.demo.repository.HighScoreRepository;
import com.example.quartz.demo.repository.RpgCharacterRepository;

@Service
public class HighScoreService {

    @Autowired
    private RpgCharacterRepository rpgCharacterRepository;

    @Autowired
    private HighScoreRepository highScoreRepository;

    public void updateHighScores() {
        highScoreRepository.deleteAll();
        List<RpgCharacter> topCharacters = rpgCharacterRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "level"))).getContent();
        System.out.println("TOP CHARACTERS -> " + topCharacters);
        List<RpgCharacterHighScore> characterHighScores = topCharacters.stream().map(character -> new RpgCharacterHighScore(character)).toList();

        HighScore highScore = new HighScore(characterHighScores, Instant.now());
        highScoreRepository.save(highScore);
    }
}