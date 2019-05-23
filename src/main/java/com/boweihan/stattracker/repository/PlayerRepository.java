package com.boweihan.stattracker.repository;

import com.boweihan.stattracker.entity.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlayerRepository extends CrudRepository<Player, UUID> {}