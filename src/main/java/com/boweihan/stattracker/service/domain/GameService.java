package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Game;

import java.util.Optional;
import java.util.UUID;

public interface GameService {
    Game createGame(Game game);

    Iterable<Game> getGames();

    Optional<Game> getGame(UUID gameId);

    Game saveGame(Game game);

    void deleteGame(Game game);
}
