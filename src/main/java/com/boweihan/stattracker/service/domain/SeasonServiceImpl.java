package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Season;
import com.boweihan.stattracker.repository.domain.SeasonRepository;
import com.boweihan.stattracker.service.exception.domain.SeasonConflictException;

import java.util.Optional;
import java.util.UUID;

public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public Season createSeason(Season season) {
        if (seasonRepository.existsById(season.getId())) {
            throw new SeasonConflictException();
        }

        return seasonRepository.save(season);
    }

    @Override
    public Iterable<Season> getSeasons() {
        return seasonRepository.findAll();
    }

    @Override
    public Optional<Season> getSeason(UUID seasonId) {
        return seasonRepository.findById(seasonId);
    }

    @Override
    public Season saveSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public void deleteSeason(Season season) {
        seasonRepository.delete(season);
    }
}
