package com.project.toyland.auth.oauth2.dto;

import com.project.toyland.user.domain.entity.UserEntity;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(UserEntity user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}