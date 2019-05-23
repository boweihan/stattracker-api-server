package com.boweihan.stattracker.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match extends EntityWithUUID {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_match_season"))
    private Season season;
}
