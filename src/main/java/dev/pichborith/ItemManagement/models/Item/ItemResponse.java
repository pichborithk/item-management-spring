package dev.pichborith.ItemManagement.models.Item;

import java.math.BigDecimal;
import java.util.Set;

public record ItemResponse (
    int id,
    String name,
    BigDecimal price,
    String category,
    Set<InventoryDTO> inventories
){
}
