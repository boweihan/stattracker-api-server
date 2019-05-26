package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Player;
import com.boweihan.stattracker.repository.domain.PlayerRepository;
import com.boweihan.stattracker.service.exception.domain.PlayerConflictException;

import java.util.Optional;
import java.util.UUID;

public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player createPlayer(Player player) {
        if (playerRepository.existsById(player.getId())) {
            throw new PlayerConflictException();
        }

        return playerRepository.save(player);
    }

    @Override
    public Iterable<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> getPlayer(UUID playerId) {
        return playerRepository.findById(playerId);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }
}
