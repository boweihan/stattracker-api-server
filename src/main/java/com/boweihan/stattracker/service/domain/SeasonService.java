package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Season;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface SeasonService {
    Season createSeason(Season season);

    Iterable<Season> getSeasons();

    Optional<Season> getSeason(UUID seasonId);

    Season saveSeason(Season season);

    void deleteSeason(Season season);
}
