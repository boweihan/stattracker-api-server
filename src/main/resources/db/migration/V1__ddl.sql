CREATE TABLE season
  (
     id             UUID NOT NULL,
     name           VARCHAR(255),
     description    VARCHAR(255),
     PRIMARY KEY (id)
  );

CREATE TABLE match
  (
     id         UUID NOT NULL,
     timestamp  TIMESTAMP WITH TIME ZONE,
     season_id  UUID,
     PRIMARY KEY (id),
     CONSTRAINT fk_match_season FOREIGN KEY (season_id) REFERENCES match
  );

CREATE TABLE team
  (
     id             UUID NOT NULL,
     name           VARCHAR(255),
     PRIMARY KEY (id)
  );

CREATE TABLE game
  (
     id                 UUID NOT NULL,
     winning_team_id    UUID,
     losing_team_id     UUID,
     winning_score      INT,
     losing_score       INT,
     match_id           UUID,
     PRIMARY KEY (id),
     CONSTRAINT fk_game_match FOREIGN KEY (match_id) REFERENCES game,
     CONSTRAINT fk_game_winning_team FOREIGN KEY (winning_team_id) REFERENCES team,
     CONSTRAINT fk_game_losing_team FOREIGN KEY (losing_team_id) REFERENCES team
  );

CREATE TABLE player
  (
     id         UUID NOT NULL,
     name       VARCHAR(255),
     email      VARCHAR(255),
     PRIMARY KEY (id)
  );

CREATE TABLE player_team
  (
     player_id       UUID,
     team_id         UUID,
     CONSTRAINT uk_player_teams UNIQUE (player_id, team_id),
     CONSTRAINT fk_player_teams_player FOREIGN KEY (player_id) REFERENCES player,
     CONSTRAINT fk_player_teams_team_fk FOREIGN KEY (team_id) REFERENCES team
  );