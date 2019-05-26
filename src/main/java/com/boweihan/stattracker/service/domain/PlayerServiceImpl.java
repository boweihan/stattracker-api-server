package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Player;
import com.boweihan.stattracker.repository.domain.PlayerRepository;
import com.boweihan.stattracker.service.exception.domain.PlayerConflictException;
import com.boweihan.stattracker.service.exception.domain.PlayerNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public List<Player> getPlayers() {
        return StreamSupport.stream(
                playerRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Player getPlayer(UUID playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (!player.isPresent()) {
            throw new PlayerNotFoundException();
        }
        return player.get();
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(UUID playerId) {
        playerRepository.deleteById(playerId);
    }
}
