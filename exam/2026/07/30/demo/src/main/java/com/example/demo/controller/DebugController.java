package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DebugController {

    @GetMapping("/api/debug")
    public Map<String, Object> debugTest() {

        int productionCount = 100;
        int defectiveCount = 5;
        int goodCount = productionCount - defectiveCount;

        Map<String, Object> result = new HashMap<>();

        result.put("productionCount", productionCount);
        result.put("defectiveCount", defectiveCount);
        result.put("goodCount", goodCount);
        result.put("message", "생산 현황 조회 성공");

        return result;
    }
}