package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface PlayerService {
    Player createPlayer(Player player);

    Iterable<Player> getPlayers();

    Optional<Player> getPlayer(UUID playerId);

    Player savePlayer(Player player);

    void deletePlayer(Player player);
}
