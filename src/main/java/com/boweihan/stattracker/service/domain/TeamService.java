package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface TeamService {
    Team createTeam(Team team);

    Iterable<Team> getTeams();

    Optional<Team> getTeam(UUID teamId);

    Team saveTeam(Team team);

    void deleteTeam(Team team);
}
