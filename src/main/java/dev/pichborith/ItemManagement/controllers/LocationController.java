package dev.pichborith.ItemManagement.controllers;

import dev.pichborith.ItemManagement.models.location.LocationRequest;
import dev.pichborith.ItemManagement.models.location.LocationResponse;
import dev.pichborith.ItemManagement.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAllLocations() {
        var locations = locationService.getAll();
        return ResponseEntity.ok(locations);
    }

    @PostMapping
    public ResponseEntity<LocationResponse> createLocation(@RequestBody
                                                           LocationRequest request) {
        var location = locationService.add(request);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

}
