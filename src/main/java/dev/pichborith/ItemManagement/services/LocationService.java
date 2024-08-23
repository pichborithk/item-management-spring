package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.exception.BadRequestException;
import dev.pichborith.ItemManagement.exception.NotFoundException;
import dev.pichborith.ItemManagement.models.location.LocationInventoryRequest;
import dev.pichborith.ItemManagement.models.location.LocationRequest;
import dev.pichborith.ItemManagement.models.location.LocationResponse;
import dev.pichborith.ItemManagement.repositories.InventoryRepository;
import dev.pichborith.ItemManagement.repositories.ItemRepository;
import dev.pichborith.ItemManagement.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;

    public List<LocationResponse> getAll() {
        var locations = locationRepository.findAll();
        List<LocationResponse> locationResponses = new ArrayList<>();

        for (var location : locations) {
            var inventories = inventoryRepository.findAllByLocationId(
                location.getId());
            var locationResponse = locationMapper.toLocationResponse(location,
                                                                     inventories);
            locationResponses.add(locationResponse);
        }

        return locationResponses;
    }

    public LocationResponse add(LocationRequest request) {
        var location = locationRepository.save(
            locationMapper.toLocation(request));
        return locationMapper.toLocationResponse(location);
    }

    public LocationResponse addItemToInventory(int locationId,
                                               LocationInventoryRequest request) {
        var location = locationRepository.findById(locationId)
                                         .orElseThrow(
                                             () -> new NotFoundException(
                                                 String.format(
                                                     "Location with ID: %d doesn't exist",
                                                     locationId)));

        var itemId = request.itemId();
        itemRepository.findById(request.itemId())
                      .orElseThrow(() -> new NotFoundException(
                          String.format("Item with ID: %d doesn't exist",
                                        itemId)));

        if (inventoryRepository.existsByItemIdAndLocationId(itemId,
                                                            locationId)) {
            throw new BadRequestException(String.format(
                "Item with ID: %d already exist in inventory of Location with ID: %d",
                itemId, locationId));
        }

        inventoryRepository.addItemToInventory(itemId,
                                               locationId,
                                               request.quantity());

        var inventories = inventoryRepository.findAllByLocationId(locationId);

        return locationMapper.toLocationResponse(location, inventories);
    }

    public LocationResponse updateItemQuantityInInventory(int locationId, LocationInventoryRequest request) {
        var location = locationRepository.findById(locationId)
                                         .orElseThrow(
                                             () -> new NotFoundException(
                                                 String.format(
                                                     "Location with ID: %d doesn't exist",
                                                     locationId)));

        var itemId = request.itemId();
        itemRepository.findById(request.itemId())
                      .orElseThrow(() -> new NotFoundException(
                          String.format("Item with ID: %d doesn't exist",
                                        itemId)));

        if (!inventoryRepository.existsByItemIdAndLocationId(itemId,
                                                            locationId)) {
            throw new BadRequestException(String.format(
                "Item with ID: %d doesn't exist in inventory of Location with ID: %d",
                itemId, locationId));
        }

        inventoryRepository.updateItemQuantityInInventory(itemId, locationId,
                                                          request.quantity());

        var inventories = inventoryRepository.findAllByLocationId(locationId);

        return locationMapper.toLocationResponse(location, inventories);
    }
}
