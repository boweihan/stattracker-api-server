package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {
    Player createPlayer(Player player);

    List<Player> getPlayers();

    Player getPlayer(UUID playerId);

    Player savePlayer(Player player);

    void deletePlayer(UUID playerId);
}
