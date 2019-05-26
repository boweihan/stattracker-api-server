package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Team;
import com.boweihan.stattracker.repository.domain.TeamRepository;
import com.boweihan.stattracker.service.exception.domain.TeamConflictException;

import java.util.Optional;
import java.util.UUID;

public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createTeam(Team team) {
        if (teamRepository.existsById(team.getId())) {
            throw new TeamConflictException();
        }

        return teamRepository.save(team);
    }

    @Override
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> getTeam(UUID teamId) {
        return teamRepository.findById(teamId);
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Team team) {
        teamRepository.delete(team);
    }
}
