package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.Item;
import dev.pichborith.ItemManagement.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAll() {
        return itemRepository.findAllWithCategory();
    }
}
