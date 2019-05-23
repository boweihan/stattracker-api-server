package com.boweihan.stattracker.repository;

import com.boweihan.stattracker.entity.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MatchRepository extends CrudRepository<Match, UUID> {}