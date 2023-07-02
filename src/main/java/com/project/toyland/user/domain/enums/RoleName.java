package com.project.toyland.user.domain.enums;

import lombok.Getter;

@Getter
public enum RoleName {

    USER("ROLE_USER", "일반 사용자"),
    SYSTEM_MANAGER("ROLE_SYSTEM_MANAGER", "시스템 관리자");

    private final String key;

    private final String description;

    RoleName(String key, String description) {
        this.key = key;
        this.description = description;
    }
}
