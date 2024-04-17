package org.example.gamemarket.repository;

import org.example.gamemarket.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface GameRepository extends JpaRepository<Game, UUID> {
    Game findGameById(UUID id);

    Game findGameByName(String name);
    Game save(Game game);
}
