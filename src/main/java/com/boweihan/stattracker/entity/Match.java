package com.boweihan.stattracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match extends EntityWithUUID {
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_match_season"))
    private Season season;
}
