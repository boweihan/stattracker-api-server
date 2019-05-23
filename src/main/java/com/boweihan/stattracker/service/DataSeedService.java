package com.boweihan.stattracker.service;

import com.boweihan.stattracker.entity.Match;
import com.boweihan.stattracker.entity.Season;
import com.boweihan.stattracker.repository.MatchRepository;
import com.boweihan.stattracker.repository.SeasonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class DataSeedService {
    private final MatchRepository matchRepository;
    private final SeasonRepository seasonRepository;

    public DataSeedService(MatchRepository matchRepository, SeasonRepository seasonRepository) {
        this.matchRepository = matchRepository;
        this.seasonRepository = seasonRepository;
    }

    @PostConstruct
    @Transactional
    public void fillData(){
        Season s1 = new Season("Season 1", "The First Season");
        Season s2 = new Season("Season 2", "The Second Season");
        seasonRepository.save(s1);
        seasonRepository.save(s2);

        Match m1 = new Match("Match 1", s1);
        Match m2 = new Match("Match 2", s2);

        matchRepository.save(m1);
        matchRepository.save(m2);


    }
}