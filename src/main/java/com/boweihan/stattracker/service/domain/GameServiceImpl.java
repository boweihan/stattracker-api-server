package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Game;
import com.boweihan.stattracker.repository.domain.GameRepository;
import com.boweihan.stattracker.service.exception.domain.GameConflictException;

import java.util.Optional;
import java.util.UUID;

public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(Game game) {
        if (gameRepository.existsById(game.getId())) {
            throw new GameConflictException();
        }

        return gameRepository.save(game);
    }

    @Override
    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> getGame(UUID gameId) {
        return gameRepository.findById(gameId);
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(Game game) {
        gameRepository.delete(game);
    }
}
