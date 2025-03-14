package com.api.tracking.controller;

import com.api.tracking.request.TrackingRequest;
import com.api.tracking.service.TrackingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/next-tracking-number")
class TrackingController {
    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping
    public Map<String, String> getTrackingNumber(@Valid TrackingRequest request) {
        String trackingNumber = trackingService.generateTrackingNumber();
        String createdAt = Instant.now().toString();

        Map<String, String> response = new HashMap<>();
        response.put("tracking_number", trackingNumber);
        response.put("created_at", createdAt);
        return response;
    }
}
