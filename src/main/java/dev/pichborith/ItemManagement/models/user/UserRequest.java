package dev.pichborith.ItemManagement.models.user;

public record UserRequest(
    String id,
    String username,
    String password
) {}
