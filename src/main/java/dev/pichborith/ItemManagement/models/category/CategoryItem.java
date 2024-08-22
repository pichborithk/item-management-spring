package dev.pichborith.ItemManagement.models.category;

import java.math.BigDecimal;

public record CategoryItem(
    int itemId,
    String name,
    BigDecimal price
) {
}
