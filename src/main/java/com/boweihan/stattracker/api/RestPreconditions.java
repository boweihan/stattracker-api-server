package com.boweihan.stattracker.api;

import com.boweihan.stattracker.model.domain.*;
import com.boweihan.stattracker.service.exception.domain.*;

public class RestPreconditions {
    public static <T> T checkFound(T resource) {
        if (resource == null) {
            if (resource instanceof Game) {
                throw new GameNotFoundException();
            } else if (resource instanceof Match) {
                throw new MatchNotFoundException();
            } else if (resource instanceof Player) {
                throw new PlayerNotFoundException();
            } else if (resource instanceof Season) {
                throw new SeasonNotFoundException();
            } else if (resource instanceof Team) {
                throw new TeamNotFoundException();
            } else {
                throw new GenericNotFoundException();
            }
        }
        return resource;
    }
}