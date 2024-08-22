package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.item.InventoryDTO;
import dev.pichborith.ItemManagement.models.item.Item;
import dev.pichborith.ItemManagement.models.item.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMapper {

    public ItemResponse toItemResponse(Item item, List<InventoryDTO> inventories) {
        return new ItemResponse(item.getId(), item.getName(), item.getPrice(),
                                item.getCategory().getName(), inventories);
    }
}
