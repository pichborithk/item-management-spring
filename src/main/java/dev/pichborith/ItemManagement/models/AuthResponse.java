package dev.pichborith.ItemManagement.models;

import java.util.Map;

public record AuthResponse(boolean success, String message, Map<String, String> data) {

    public AuthResponse(String message, Map<String, String> data) {
        this(true, message, data);
    }
}
