package com.example.demo.config;

import com.example.demo.entity.Equipment;
import com.example.demo.entity.ProductionLog;
import com.example.demo.repository.EquipmentRepository;
import com.example.demo.repository.ProductionLogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeData(
            EquipmentRepository equipmentRepository,
            ProductionLogRepository productionLogRepository
    ) {
        return args -> {

            if (equipmentRepository.count() > 0) {
                return;
            }

            Equipment equipment1 = new Equipment(
                    "EQ001",
                    "포장 설비 1호기",
                    "RUNNING"
            );

            Equipment equipment2 = new Equipment(
                    "EQ002",
                    "검사 설비 1호기",
                    "STOPPED"
            );

            equipmentRepository.save(equipment1);
            equipmentRepository.save(equipment2);

            productionLogRepository.save(
                    new ProductionLog(
                            equipment1,
                            120,
                            5,
                            LocalDateTime.now()
                    )
            );

            productionLogRepository.save(
                    new ProductionLog(
                            equipment1,
                            150,
                            3,
                            LocalDateTime.now()
                    )
            );

            productionLogRepository.save(
                    new ProductionLog(
                            equipment2,
                            85,
                            2,
                            LocalDateTime.now()
                    )
            );

            System.out.println("[DB] 설비 및 생산실적 데이터 저장 완료");
        };
    }
}