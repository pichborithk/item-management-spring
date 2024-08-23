package dev.pichborith.ItemManagement.models.location;

public record LocationInventoryRequest(
    int itemId,
    int quantity
) {
}
