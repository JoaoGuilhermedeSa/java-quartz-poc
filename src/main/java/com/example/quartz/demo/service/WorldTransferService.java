package com.example.quartz.demo.service;

import com.example.quartz.demo.domain.RpgCharacter;
import com.example.quartz.demo.domain.WorldTransferRequest;
import com.example.quartz.demo.repository.RpgCharacterRepository;
import com.example.quartz.demo.repository.WorldTransferRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WorldTransferService {

	private static final Logger logger = LoggerFactory.getLogger(WorldTransferService.class);
    @Autowired
    private WorldTransferRequestRepository worldTransferRequestRepository;

    @Autowired
    private RpgCharacterRepository rpgCharacterRepository;

    public void processPendingTransfers() {
        List<WorldTransferRequest> pendingRequests = worldTransferRequestRepository.findByStatus("PENDING");
        		for (WorldTransferRequest request : pendingRequests) {
        			logger.info("Processing world transfer for character: {}", request.getCharacter().getName());
        			RpgCharacter character = request.getCharacter();            character.setCurrentWorld(request.getDestinationWorld());
            rpgCharacterRepository.save(character);

            request.setStatus("COMPLETED");
            worldTransferRequestRepository.save(request);
        }
    }
}
