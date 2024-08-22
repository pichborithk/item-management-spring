package dev.pichborith.ItemManagement.models.item;

import java.math.BigDecimal;
import java.util.List;

public record ItemResponse (
    int id,
    String name,
    BigDecimal price,
    String category,
    List<ItemInventory> inventories
){
}
