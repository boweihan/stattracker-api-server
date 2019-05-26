package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Match;

import java.util.List;
import java.util.UUID;

public interface MatchService {
    Match createMatch(Match match);

    List<Match> getMatchs();

    Match getMatch(UUID matchId);

    Match saveMatch(Match match);

    void deleteMatch(UUID matchId);
}
