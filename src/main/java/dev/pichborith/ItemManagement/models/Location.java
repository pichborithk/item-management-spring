package dev.pichborith.ItemManagement.models;

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
    private String name;

    private String description;

    @OneToMany(mappedBy = "location")
    private Set<Inventory> inventories;
}