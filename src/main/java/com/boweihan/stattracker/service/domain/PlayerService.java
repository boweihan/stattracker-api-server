package com.boweihan.stattracker.service.domain;

import com.boweihan.stattracker.model.domain.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerService {
    Player createPlayer(Player player);

    Page<Player> getPlayers(Pageable pageable);

    Player getPlayer(Long playerId);

    Player savePlayer(Player player);

    void deletePlayer(Player player);
}
