package dev.pichborith.ItemManagement.services;

import dev.pichborith.ItemManagement.models.location.Location;
import dev.pichborith.ItemManagement.models.location.LocationInventory;
import dev.pichborith.ItemManagement.models.location.LocationRequest;
import dev.pichborith.ItemManagement.models.location.LocationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationMapper {

    public LocationResponse toLocationResponse(Location location, List<LocationInventory> inventories) {
        return new LocationResponse(location.getId(), location.getType(),
                                    inventories);
    }

    public Location toLocation(LocationRequest request) {
        return new Location(request.id(), request.type());
    }
}
