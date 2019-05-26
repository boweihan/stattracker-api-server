package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Game;

import java.util.List;
import java.util.UUID;

public interface GameService {
    Game createGame(Game game);

    List<Game> getGames();

    Game getGame(UUID gameId);

    Game saveGame(Game game);

    void deleteGame(UUID gameId);
}
