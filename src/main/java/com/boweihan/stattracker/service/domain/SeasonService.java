package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Season;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeasonService {
    Season createSeason(Season season);

    Page<Season> getSeasons(Pageable pageable);

    Season getSeason(Long seasonId);

    Season saveSeason(Season season);

    void deleteSeason(Season season);
}
