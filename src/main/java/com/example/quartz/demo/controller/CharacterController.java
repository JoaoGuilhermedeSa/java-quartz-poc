package com.example.quartz.demo.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quartz.demo.domain.RpgCharacter;
import com.example.quartz.demo.repository.RpgCharacterRepository;

@RestController
public class CharacterController {

    @Autowired
    private RpgCharacterRepository rpgCharacterRepository;

    @PostMapping("/characters")
    public RpgCharacter createCharacter(@RequestBody RpgCharacter character) {
        character.setLevel(ThreadLocalRandom.current().nextInt(1, 100));
        return rpgCharacterRepository.save(character);
    }

    @GetMapping("/characters")
    public List<RpgCharacter> listCharacters() {
        return rpgCharacterRepository.findAll();
    }
}
