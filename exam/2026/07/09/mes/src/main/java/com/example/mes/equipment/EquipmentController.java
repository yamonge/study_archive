package com.example.mes.equipment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(origins = "http://localhost:3000")
public class EquipmentController {

    private final List<EquipmentStatus> statusList = new ArrayList<>();

    @PostMapping("/status")
    public ResponseEntity<Map<String, String>> receiveStatus(@RequestBody EquipmentStatus status) {
        if (!isValidState(status.getState())) {
            return ResponseEntity.badRequest()
                    .body(Map.of("result", "fail", "message", "허용되지 않은 상태값입니다."));
        }

        statusList.add(status);
        return ResponseEntity.ok(Map.of("result", "ok"));
    }

    @GetMapping("/status")
    public List<EquipmentStatus> getStatusList() {
        return statusList;
    }

    private boolean isValidState(String state) {
        return "RUN".equals(state)
                || "STOP".equals(state)
                || "ERROR".equals(state);
    }
}