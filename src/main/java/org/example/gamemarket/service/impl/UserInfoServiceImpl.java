package org.example.gamemarket.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.gamemarket.entity.UserInfo;
import org.example.gamemarket.exception.ErrorMessage;
import org.example.gamemarket.exception.UserInfoDoesNotExistException;
import org.example.gamemarket.repository.UserInfoRepository;
import org.example.gamemarket.service.interfaces.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserInfo getUserInfoById(UUID id) {
        UserInfo userInfo = userInfoRepository.findUserInfoById(id);
        if (userInfo == null) {
            throw new UserInfoDoesNotExistException(ErrorMessage.THIS_USERINFO_DOES_NOT_EXIST);
        }
        return userInfo;
    }

    @Override
    public UserInfo getUserInfoByLogin(String login) {
        UserInfo userInfo = userInfoRepository.findUserInfoByLogin(login);
        if (userInfo == null) {
            throw new UserInfoDoesNotExistException(ErrorMessage.THIS_USERINFO_DOES_NOT_EXIST);
        }
        return userInfo;
    }
}
