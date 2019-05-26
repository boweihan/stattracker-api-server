package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Season;
import com.boweihan.stattracker.repository.domain.SeasonRepository;
import com.boweihan.stattracker.service.exception.domain.SeasonConflictException;
import com.boweihan.stattracker.service.exception.domain.SeasonNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public List<Season> getSeasons() {
        return StreamSupport.stream(
                seasonRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Season getSeason(UUID seasonId) {
        Optional<Season> season = seasonRepository.findById(seasonId);
        if (!season.isPresent()) {
            throw new SeasonNotFoundException();
        }
        return season.get();
    }

    @Override
    public Season saveSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public void deleteSeason(UUID seasonId) {
        seasonRepository.deleteById(seasonId);
    }
}
