package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.location.Location;
import dev.pichborith.ItemManagement.models.location.LocationInventory;
import dev.pichborith.ItemManagement.models.location.LocationRequest;
import dev.pichborith.ItemManagement.models.location.LocationResponse;
import dev.pichborith.ItemManagement.repositories.InventoryRepository;
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

    public List<LocationResponse> getAll() {
        List<Location> locations = locationRepository.findAll();
        List<LocationResponse> locationResponses = new ArrayList<>();

        for (var location : locations) {
            List<LocationInventory> inventories = inventoryRepository.findAllByLocationId(
                location.getId());
            var locationResponse = locationMapper.toLocationResponse(location,
                                                                     inventories);
            locationResponses.add(locationResponse);
        }

        return locationResponses;
    }

    public LocationResponse add(LocationRequest request) {
        Location location = locationRepository.save(locationMapper.toLocation(request));
        return locationMapper.toLocationResponse(location);
    }
}
