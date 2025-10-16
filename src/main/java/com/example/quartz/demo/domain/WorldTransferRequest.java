package com.example.quartz.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WorldTransferRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RpgCharacter character;

    private String sourceWorld;

    private String destinationWorld;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RpgCharacter getCharacter() {
        return character;
    }

    public void setCharacter(RpgCharacter character) {
        this.character = character;
    }

    public String getSourceWorld() {
        return sourceWorld;
    }

    public void setSourceWorld(String sourceWorld) {
        this.sourceWorld = sourceWorld;
    }

    public String getDestinationWorld() {
        return destinationWorld;
    }

    public void setDestinationWorld(String destinationWorld) {
        this.destinationWorld = destinationWorld;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
