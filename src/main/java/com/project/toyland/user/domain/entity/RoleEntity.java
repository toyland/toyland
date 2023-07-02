package com.project.toyland.user.domain.entity;

import com.project.toyland.common.entity.BaseEntity;
import com.project.toyland.user.domain.enums.RoleName;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoleEntity extends BaseEntity {

    private static final int MAX_AUTHORITY = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private RoleName name;

    public RoleEntity(RoleName name) {
        this.name = name;
    }

}
