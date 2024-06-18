package org.example.gamemarket.service.interfaces;

import org.example.gamemarket.entity.UserInfo;

import java.util.UUID;

public interface UserInfoService {
    UserInfo getUserInfoById(UUID id);

    UserInfo getUserInfoByLogin(String login);
}
