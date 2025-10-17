package com.example.quartz.demo.domain;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HighScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JdbcTypeCode(SqlTypes.JSON)
    @ElementCollection
    List<RpgCharacterHighScore> characters;
    
    private Instant instant;

    public HighScore() {
    }

    public HighScore(List<RpgCharacterHighScore> characters, Instant instant) {
        this.characters = characters;
        this.instant = instant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Instant getInstant() {
    	return instant;
    }

    public List<RpgCharacterHighScore> getCharacters() {
        return characters;
    }

}
