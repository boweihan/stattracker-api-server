package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Match;
import com.boweihan.stattracker.repository.domain.MatchRepository;
import com.boweihan.stattracker.service.exception.domain.MatchConflictException;
import com.boweihan.stattracker.service.exception.domain.MatchNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public List<Match> getMatchs() {
        return StreamSupport.stream(
                matchRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Match getMatch(UUID matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        if (!match.isPresent()) {
            throw new MatchNotFoundException();
        }
        return match.get();
    }

    @Override
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteMatch(UUID matchId) {
        matchRepository.deleteById(matchId);
    }
}
