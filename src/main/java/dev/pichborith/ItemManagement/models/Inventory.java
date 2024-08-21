package dev.pichborith.ItemManagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Location location;

    @Column(nullable = false)
    private Integer quantity;

}
