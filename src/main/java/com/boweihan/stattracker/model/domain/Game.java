package com.boweihan.stattracker.model.domain;


import com.boweihan.stattracker.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game extends BaseModel {
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
