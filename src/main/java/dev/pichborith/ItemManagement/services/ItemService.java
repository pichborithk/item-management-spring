package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.exception.NotFoundException;
import dev.pichborith.ItemManagement.models.item.ItemRequest;
import dev.pichborith.ItemManagement.models.item.ItemResponse;
import dev.pichborith.ItemManagement.repositories.CategoryRepository;
import dev.pichborith.ItemManagement.repositories.InventoryRepository;
import dev.pichborith.ItemManagement.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final InventoryRepository inventoryRepository;
    private final CategoryRepository categoryRepository;

    public List<ItemResponse> getAll() {
        var items = itemRepository.findAllWithCategory();
        List<ItemResponse> response = new ArrayList<>();

        for (var item : items) {
            var inventories = inventoryRepository.findAllByItemId(item.getId());
            var itemResponse = itemMapper.toItemResponse(item, inventories);

            response.add(itemResponse);
        }

        return response;
    }

    public ItemResponse getById(int itemId) {
        var item = itemRepository.findByIdAllWithCategory(itemId);
        var inventories = inventoryRepository.findAllByItemId(
            itemId);

        return itemMapper.toItemResponse(item, inventories);
    }

    public ItemResponse add(ItemRequest request) {
        var category = categoryRepository.findById(request.categoryId())
                                         .orElseThrow(
                                             () -> new NotFoundException(
                                                 String.format(
                                                     "Category with ID: %d doesn't exist",
                                                     request.categoryId())));

        var item = itemMapper.toItem(request);
        item.setCategory(category);
        return itemMapper.toItemResponse(itemRepository.save(item));
    }
}
