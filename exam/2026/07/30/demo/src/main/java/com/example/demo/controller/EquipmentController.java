package com.example.demo.controller;

import com.example.demo.entity.Equipment;
import com.example.demo.repository.EquipmentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    public EquipmentController(
            EquipmentRepository equipmentRepository
    ) {
        this.equipmentRepository = equipmentRepository;
    }

    @GetMapping("/api/equipment")
    public List<Equipment> getEquipmentList() {
        return equipmentRepository.findAll();
    }
}