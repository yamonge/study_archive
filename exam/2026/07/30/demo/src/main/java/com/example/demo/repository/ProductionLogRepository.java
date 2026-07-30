package com.example.demo.repository;

import com.example.demo.entity.ProductionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionLogRepository
        extends JpaRepository<ProductionLog, Long> {

    List<ProductionLog> findByEquipmentId(Long equipmentId);
}