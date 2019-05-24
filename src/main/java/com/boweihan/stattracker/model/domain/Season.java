package com.boweihan.stattracker.model.domain;

import com.boweihan.stattracker.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Season extends BaseModel {
    private String name;
    private String description;
}
