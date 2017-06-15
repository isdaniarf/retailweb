package isdaniarf.retailweb.model;

import isdaniarf.retailweb.model.meta.Types.UserType;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

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

    public User() {}

    public User(String name, UserType type, LocalDate registeredDate){
        this.name = name;
        this.type = type;
        this.registeredDate = registeredDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getRegisteredYears() {
        long registeredYears = YEARS.between(getRegisteredDate(), LocalDate.now());
        return registeredYears;
    }

}
