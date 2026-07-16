package com.human.backend.controller;

import com.human.backend.service.DriverService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
public class RemoteController {

    private final DriverService driverService;

    public RemoteController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(
            value = "/sensor",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String sensor() throws IOException {
        return driverService.send("SENSOR");
    }

    @PostMapping(
            value = "/remote/button1",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String button1() throws IOException {
        return driverService.send("BTN1");
    }

    @PostMapping(
            value = "/remote/button2",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String button2() throws IOException {
        return driverService.send("BTN2");
    }

    @PostMapping(
            value = "/remote/power",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String power() throws IOException {
        return driverService.send("POWER");
    }
}