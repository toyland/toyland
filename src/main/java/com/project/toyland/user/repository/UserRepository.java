package com.project.toyland.user.repository;

import com.project.toyland.user.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * 이메일로 UserEntity 조회
     * @param email 이메일
     * @return UserEntity
     */
    Optional<UserEntity> findByEmail(String email);
}
