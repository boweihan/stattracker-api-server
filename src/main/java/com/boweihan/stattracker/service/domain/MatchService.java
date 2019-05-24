package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MatchService {
    Match createMatch(Match match);

    Page<Match> getMatchs(Pageable pageable);

    Match getMatch(Long matchId);

    Match saveMatch(Match match);

    void deleteMatch(Match match);
}
