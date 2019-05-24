package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GameService {
    Game createGame(Game game);

    Page<Game> getGames(Pageable pageable);

    Game getGame(Long gameId);

    Game saveGame(Game game);

    void deleteGame(Game game);
}
