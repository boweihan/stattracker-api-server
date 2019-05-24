package com.boweihan.stattracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game extends EntityWithUUID {
    private int winningScore;
    private int losingScore;

    @ManyToOne
    private Team winningTeam;

    @ManyToOne
    private Team losingTeam;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_game_match"))
    private Match match;
}
