package com.boweihan.stattracker.repositories;

import com.boweihan.stattracker.entities.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MatchRepository extends CrudRepository<Match, UUID> {}