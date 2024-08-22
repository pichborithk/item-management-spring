package dev.pichborith.ItemManagement.models.location;

import java.math.BigDecimal;

public interface LocationInventory {
    int getItemId();
    String getName();
    BigDecimal getPrice();
    int getQuantity();
}
