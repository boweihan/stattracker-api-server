package com.boweihan.stattracker.repository;

import com.boweihan.stattracker.entity.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GameRepository extends CrudRepository<Game, UUID> {}