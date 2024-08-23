package dev.pichborith.ItemManagement.repositories;

import dev.pichborith.ItemManagement.models.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Modifying
    @Query("DELETE FROM Location l WHERE l.id = :locationId")
    void deleteById(int locationId);
}
