package isdaniarf.retailweb.entities;

import isdaniarf.retailweb.entities.meta.Types;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */

@Entity
public class Item {

    @Id
    private Long id;
    private String name;
    private double price;
    private Types.Item type;

    public Item(String name, Types.Item type, double price) {
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

    public Types.Item getType() {
        return type;
    }

    public void setType(Types.Item type) {
        this.type = type;
    }
}
