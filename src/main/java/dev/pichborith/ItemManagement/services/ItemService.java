package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.item.InventoryDTO;
import dev.pichborith.ItemManagement.models.item.Item;
import dev.pichborith.ItemManagement.models.item.ItemResponse;
import dev.pichborith.ItemManagement.repositories.InventoryRepository;
import dev.pichborith.ItemManagement.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final InventoryRepository inventoryRepository;

    public List<ItemResponse> getAll() {
        List<Item> items = itemRepository.findAllWithCategory();
        List<ItemResponse> itemResponses = new ArrayList<>();

        for (var item : items) {
            var inventories = inventoryRepository.findAllByItemId(item.getId());
            var itemResponse = itemMapper.toItemResponse(item, inventories);

            itemResponses.add(itemResponse);
        }

        return itemResponses;
    }

    public ItemResponse getById(int itemId) {
        Item item = itemRepository.findByIdAllWithCategory(itemId);
        Set<InventoryDTO> inventories = inventoryRepository.findAllByItemId(
            itemId);

        return itemMapper.toItemResponse(item, inventories);
    }

}
