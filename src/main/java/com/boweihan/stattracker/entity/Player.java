package com.boweihan.stattracker.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends EntityWithUUID {
    private String firstName;
    private String lastName;
    private String email;
}

