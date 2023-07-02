package com.project.toyland.user.domain.entity;

import com.project.toyland.common.entity.BaseEntity;
import com.project.toyland.user.domain.enums.RoleName;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 320)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleName role;

    @Builder
    public UserEntity(String name, String email, String picture, RoleName role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public UserEntity update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
