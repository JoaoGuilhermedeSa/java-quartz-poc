package com.example.quartz.demo.repository;

import com.example.quartz.demo.domain.WorldTransferRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorldTransferRequestRepository extends JpaRepository<WorldTransferRequest, Long> {

    List<WorldTransferRequest> findByStatus(String status);
}
