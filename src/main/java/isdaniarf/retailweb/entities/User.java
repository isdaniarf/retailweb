package isdaniarf.retailweb.entities;

import isdaniarf.retailweb.entities.meta.Types.UserType;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Isdaniar_F on 14/06/2017.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    private LocalDate registeredDate;

    public User(String name, UserType type, LocalDate registeredDate){
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

}
