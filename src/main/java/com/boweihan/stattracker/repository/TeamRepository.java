package com.boweihan.stattracker.repository;

import com.boweihan.stattracker.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeamRepository extends CrudRepository<Team, UUID> {}