package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.item.ItemInventory;
import dev.pichborith.ItemManagement.models.item.Item;
import dev.pichborith.ItemManagement.models.item.ItemRequest;
import dev.pichborith.ItemManagement.models.item.ItemResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemMapper {

    public ItemResponse toItemResponse(Item item, List<ItemInventory> inventories) {
        return new ItemResponse(item.getId(), item.getName(), item.getPrice(),
                                item.getCategory().getName(), inventories);
    }

    public ItemResponse toItemResponse(Item item) {
        return new ItemResponse(item.getId(), item.getName(), item.getPrice(),
                                item.getCategory().getName(), new ArrayList<>());
    }

    public Item toItem(ItemRequest request) {
        return new Item(request.id(), request.name(), request.price());
    }
}
