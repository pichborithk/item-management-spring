package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.Item.InventoryDTO;
import dev.pichborith.ItemManagement.models.Item.Item;
import dev.pichborith.ItemManagement.models.Item.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ItemMapper {

    public ItemResponse toItemResponse(Item item, Set<InventoryDTO> inventories) {
        return new ItemResponse(item.getId(), item.getName(), item.getPrice(),
                                item.getCategory().getName(), inventories);
    }
}
