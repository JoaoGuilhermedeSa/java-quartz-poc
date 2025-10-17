package com.example.quartz.demo.controller;

import com.example.quartz.demo.domain.WorldTransferRequest;
import com.example.quartz.demo.repository.WorldTransferRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldTransferController {

    @Autowired
    private WorldTransferRequestRepository worldTransferRequestRepository;

    @PostMapping("/transfers")
    public WorldTransferRequest createTransferRequest(@RequestBody WorldTransferRequest request) {
        request.setStatus("PENDING");
        return worldTransferRequestRepository.save(request);
    }
}
