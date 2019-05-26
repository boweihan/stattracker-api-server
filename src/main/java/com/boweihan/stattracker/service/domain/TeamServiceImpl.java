package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Team;
import com.boweihan.stattracker.repository.domain.TeamRepository;
import com.boweihan.stattracker.service.exception.domain.TeamConflictException;
import com.boweihan.stattracker.service.exception.domain.TeamNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public List<Team> getTeams() {
        return StreamSupport.stream(
                teamRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Team getTeam(UUID teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (!team.isPresent()) {
            throw new TeamNotFoundException();
        }
        return team.get();
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(UUID teamId) {
        teamRepository.deleteById(teamId);
    }
}
