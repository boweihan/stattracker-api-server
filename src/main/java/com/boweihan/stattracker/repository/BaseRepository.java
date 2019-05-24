package com.boweihan.stattracker.repository;

import com.boweihan.stattracker.model.BaseModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BaseRepository<T extends BaseModel> extends CrudRepository<T, UUID> {
}
