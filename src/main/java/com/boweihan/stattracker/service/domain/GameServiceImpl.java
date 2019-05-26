package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Game;
import com.boweihan.stattracker.repository.domain.GameRepository;
import com.boweihan.stattracker.service.exception.domain.GameConflictException;
import com.boweihan.stattracker.service.exception.domain.GameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public List<Game> getGames() {
        return StreamSupport.stream(
                gameRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Game getGame(UUID gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        if (!game.isPresent()) {
            throw new GameNotFoundException();
        }
        return game.get();
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(UUID gameId) {
        gameRepository.deleteById(gameId);
    }
}
