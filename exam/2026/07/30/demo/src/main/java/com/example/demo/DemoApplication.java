package com.example.demo;

import com.example.demo.entity.Equipment;
import com.example.demo.repository.EquipmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertTestData(
			EquipmentRepository equipmentRepository
	) {
		return args -> {
			if (equipmentRepository.count() == 0) {
				equipmentRepository.save(
						new Equipment(
								"EQ001",
								"포장 설비 1호기",
								"RUNNING"
						)
				);

				equipmentRepository.save(
						new Equipment(
								"EQ002",
								"검사 설비 1호기",
								"STOPPED"
						)
				);
			}
		};
	}
}