package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
