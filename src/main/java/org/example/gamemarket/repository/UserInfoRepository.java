package org.example.gamemarket.repository;

import org.example.gamemarket.entity.User;
import org.example.gamemarket.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {
    UserInfo findUserInfoById(UUID id);

    UserInfo findUserInfoByLogin(String login);
}
