package dev.pichborith.ItemManagement.models;

public record ErrorResponse(boolean success, String message, Object data) {

    public ErrorResponse(String message) {
        this(false, message, null);
    }
}
