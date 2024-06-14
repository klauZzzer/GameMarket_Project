package org.example.gamemarket.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.Developer;
import org.example.gamemarket.entity.User;
import org.example.gamemarket.exception.DeveloperDoesNotExistException;
import org.example.gamemarket.exception.ErrorMessage;
import org.example.gamemarket.exception.UserDoesNotExistException;
import org.example.gamemarket.repository.UserRepository;
import org.example.gamemarket.service.interfaces.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User getUserById(UUID id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new UserDoesNotExistException(ErrorMessage.THIS_USER_DOES_NOT_EXIST);
        }
        return user;
    }

    @Override
    @Transactional
    public User getUserByNickname(String nickname) {
        User user = userRepository.findUserByNickname(nickname);
        if (user == null) {
            throw new UserDoesNotExistException(ErrorMessage.THIS_USER_DOES_NOT_EXIST);
        }
        return user;
    }
}
