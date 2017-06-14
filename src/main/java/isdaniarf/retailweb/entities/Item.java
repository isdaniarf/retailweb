package isdaniarf.retailweb.entities;

import isdaniarf.retailweb.entities.meta.Types.ItemType;

import javax.persistence.*;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    public Item(String name, ItemType type, double price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
