package org.example.gamemarket.controller;


import lombok.RequiredArgsConstructor;
import org.example.gamemarket.annotation.GetUserById;
import org.example.gamemarket.annotation.GetUserByNickname;
import org.example.gamemarket.entity.User;
import org.example.gamemarket.service.interfaces.UserService;
import org.example.gamemarket.validation.annotation.UUIDFormatChecker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetUserById(path = "/get/id/{id}")
    public User getUserById(@UUIDFormatChecker @PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }

    @GetUserByNickname(path = "/get/nickname/{nickname}")
    public User getUserByNickname(@PathVariable("nickname") String nickname) {
        return userService.getUserByNickname(nickname);
    }
}
