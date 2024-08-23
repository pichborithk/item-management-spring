package dev.pichborith.ItemManagement.models.location;

import dev.pichborith.ItemManagement.models.Inventory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int id;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Inventory> inventories;

    public Location(int id, String type) {
        this.id = id;
        this.type = type;
    }
}