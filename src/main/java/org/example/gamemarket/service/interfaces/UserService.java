package org.example.gamemarket.service.interfaces;

import org.example.gamemarket.entity.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);

    User getUserByNickname(String nickname);
}
