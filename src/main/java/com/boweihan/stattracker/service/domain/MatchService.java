package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface MatchService {
    Match createMatch(Match match);

    Iterable<Match> getMatchs();

    Optional<Match> getMatch(UUID matchId);

    Match saveMatch(Match match);

    void deleteMatch(Match match);
}
