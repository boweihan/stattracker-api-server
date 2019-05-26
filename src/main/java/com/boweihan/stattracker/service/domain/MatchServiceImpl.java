package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Match;
import com.boweihan.stattracker.repository.domain.MatchRepository;
import com.boweihan.stattracker.service.exception.domain.MatchConflictException;

import java.util.Optional;
import java.util.UUID;

public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match createMatch(Match match) {
        if (matchRepository.existsById(match.getId())) {
            throw new MatchConflictException();
        }

        return matchRepository.save(match);
    }

    @Override
    public Iterable<Match> getMatchs() {
        return matchRepository.findAll();
    }

    @Override
    public Optional<Match> getMatch(UUID matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteMatch(Match match) {
        matchRepository.delete(match);
    }
}
