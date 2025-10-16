package com.example.quartz.demo.repository;

import com.example.quartz.demo.domain.RpgCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpgCharacterRepository extends JpaRepository<RpgCharacter, Long> {
}
