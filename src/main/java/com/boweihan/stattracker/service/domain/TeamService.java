package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Team;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    Team createTeam(Team team);

    List<Team> getTeams();

    Team getTeam(UUID teamId);

    Team saveTeam(Team team);

    void deleteTeam(UUID teamId);
}
