package com.boweihan.stattracker.repositories;

import com.boweihan.stattracker.entities.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlayerRepository extends CrudRepository<Player, UUID> {}