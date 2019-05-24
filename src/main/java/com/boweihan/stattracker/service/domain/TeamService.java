package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeamService {
    Team createTeam(Team team);

    Page<Team> getTeams(Pageable pageable);

    Team getTeam(Long teamId);

    Team saveTeam(Team team);

    void deleteTeam(Team team);
}
