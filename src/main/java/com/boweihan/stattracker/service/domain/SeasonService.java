package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Season;

import java.util.List;
import java.util.UUID;

public interface SeasonService {
    Season createSeason(Season season);

    List<Season> getSeasons();

    Season getSeason(UUID seasonId);

    Season saveSeason(Season season);

    void deleteSeason(UUID seasonId);
}
