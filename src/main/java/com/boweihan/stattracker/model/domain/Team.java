package com.boweihan.stattracker.model.domain;

import com.boweihan.stattracker.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team extends BaseModel {
    private String name;

    @ManyToMany
    @JoinTable(name = "player_team",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name ="player_id")
    )
    private Set<Player> players;
}

