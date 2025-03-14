package com.api.tracking.service;

import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TrackingService {
    private final AtomicLong counter = new AtomicLong(1);

    public String generateTrackingNumber() {
        long uniqueId = counter.getAndIncrement();
        String randomPart = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6).toUpperCase();
        return String.format("%s%06d", randomPart, uniqueId);
    }
}
