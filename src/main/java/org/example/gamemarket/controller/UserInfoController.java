package org.example.gamemarket.controller;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.annotation.GetUserInfoById;
import org.example.gamemarket.annotation.GetUserInfoByLogin;
import org.example.gamemarket.entity.UserInfo;
import org.example.gamemarket.service.interfaces.UserInfoService;
import org.example.gamemarket.validation.annotation.UUIDFormatChecker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/userInfo")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetUserInfoById(path = "/get/id/{id}")
    public UserInfo getUserInfoById(@UUIDFormatChecker @PathVariable("id") UUID id) {
        return userInfoService.getUserInfoById(id);
    }

    @GetUserInfoByLogin(path = "/get/login/{login}")
    public UserInfo getUserInfoByLogin(@PathVariable("login") String login) {
        return userInfoService.getUserInfoByLogin(login);
    }
}
