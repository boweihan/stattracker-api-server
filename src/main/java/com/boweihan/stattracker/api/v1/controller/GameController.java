package com.boweihan.stattracker.api.v1.controller;

import com.boweihan.stattracker.model.domain.Game;
import com.boweihan.stattracker.service.domain.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/games")
class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<Game> findAll() {
        return service.getGames();
    }

    @GetMapping(value = "/{id}")
    public Game findById(@PathVariable("id") UUID gameId) {
        return service.getGame(gameId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(@RequestBody @Valid Game game) {
        return service.createGame(game);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID gameId) {
        service.deleteGame(gameId);
    }

}