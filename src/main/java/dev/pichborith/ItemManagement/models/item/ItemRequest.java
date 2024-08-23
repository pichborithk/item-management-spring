package dev.pichborith.ItemManagement.models.item;

import java.math.BigDecimal;

public record ItemRequest(
    int id,
    String name,
    BigDecimal price,
    int categoryId
) {
}
