package com.example.quartz.demo.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class RpgCharacterHighScore {

    private Long id;

    private String name;
    
    private int level;
    
    private String world;
    
    public RpgCharacterHighScore(RpgCharacter character) {
    	this.id = character.getId();
    	this.name = character.getName();
    	this.level = character.getLevel();
    	this.world = character.getCurrentWorld();
    }
    
    public RpgCharacterHighScore() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getWorld() {
        return world;
    }

 
}
