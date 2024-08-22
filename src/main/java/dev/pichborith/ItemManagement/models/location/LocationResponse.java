package dev.pichborith.ItemManagement.models.location;

import java.util.List;

public record LocationResponse(
    int id,
    String type,
    List<LocationInventory> inventory
) {
}
