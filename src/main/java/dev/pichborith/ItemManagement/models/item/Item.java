package dev.pichborith.ItemManagement.models.item;

import dev.pichborith.ItemManagement.models.category.Category;
import dev.pichborith.ItemManagement.models.Inventory;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Set<Inventory> inventories;

    public Item( int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
