package com.boweihan.stattracker.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseModel {
    private Instant timeCreated;

    @Nullable
    private Instant timeUpdated;

    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    public BaseModel() {
        this.id = UUID.randomUUID();
    }

    @PrePersist
    protected void onCreate() {
        timeCreated = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        timeUpdated = Instant.now();
    }
}