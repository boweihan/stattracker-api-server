package com.boweihan.stattracker.repositories;

import com.boweihan.stattracker.entities.Season;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SeasonRepository extends CrudRepository<Season, UUID> {}