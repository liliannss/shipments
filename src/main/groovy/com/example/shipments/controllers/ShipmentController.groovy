package com.example.shipments.controllers

import com.example.shipments.services.FileService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/shipments")
class ShipmentController {

    private final FileService service

    ShipmentController(FileService service) {
        this.service = service
    }

    @PostMapping
    void createShipment() {
        service.processFile()
    }
}