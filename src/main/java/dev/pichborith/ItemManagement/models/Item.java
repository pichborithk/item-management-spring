package dev.pichborith.ItemManagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "items")
@NoArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(nullable = false)
    private String name;

    private BigDecimal price;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "item")
    private Set<Inventory> inventories;
}
