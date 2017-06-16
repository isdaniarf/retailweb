package isdaniarf.retailweb.model;

import isdaniarf.retailweb.model.meta.Types;

import javax.persistence.*;

/**
 * Created by Isdaniar_F on 16/06/2017.
 */

@Entity
public class DiscountScheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Double discount;
    public String code;

    @Enumerated(EnumType.STRING)
    public Types.DiscountType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Types.DiscountType getType() {
        return type;
    }

    public void setType(Types.DiscountType type) {
        this.type = type;
    }
}
