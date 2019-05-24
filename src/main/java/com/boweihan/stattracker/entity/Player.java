package com.boweihan.stattracker.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends EntityWithUUID {
    private String name;
    private String email;

    @ManyToMany(mappedBy="players")
    private Set<Team> teams;
}

