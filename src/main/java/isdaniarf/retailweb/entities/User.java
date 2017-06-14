package isdaniarf.retailweb.entities;

import isdaniarf.retailweb.entities.meta.Types;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */

@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private Types.User type;
    private LocalDate registeredDate;

    public User(String name, Types.User type, LocalDate registeredDate){
        this.name = name;
        this.type = type;
        this.registeredDate = registeredDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types.User getType() {
        return type;
    }

    public void setType(Types.User type) {
        this.type = type;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

}
