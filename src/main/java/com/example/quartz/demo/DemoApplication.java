package com.example.quartz.demo;

import com.example.quartz.demo.domain.RpgCharacter;
import com.example.quartz.demo.domain.WorldTransferRequest;
import com.example.quartz.demo.repository.RpgCharacterRepository;
import com.example.quartz.demo.repository.WorldTransferRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	@Autowired
	private RpgCharacterRepository rpgCharacterRepository;

	@Autowired
	private WorldTransferRequestRepository worldTransferRequestRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RpgCharacter character = new RpgCharacter();
		character.setName("Gandalf");
		character.setCurrentWorld("Middle-earth");
		rpgCharacterRepository.save(character);

		logger.info("Sample character created: {}", character.getName());

		WorldTransferRequest request = new WorldTransferRequest();
		request.setCharacter(character);
		request.setSourceWorld("Middle-earth");
		request.setDestinationWorld("Valinor");
		request.setStatus("PENDING");
		worldTransferRequestRepository.save(request);
	}
}
