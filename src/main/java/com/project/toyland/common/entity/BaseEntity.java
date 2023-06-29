package com.project.toyland.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 공통 베이스 엔티티
 */
@EntityListeners(AuditingEntityListener.class)  // 엔티티의 생성 및 수정 시간을 자동으로 관리하기위한 엔티티 리스너
@MappedSuperclass   // 테이블로 맵핑되지않고, 단순히 속성만 받아서 사용
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

	/**
	 * 생성자
	 */
	@CreatedBy
	@Column(name = "created_by", updatable = false)
	private String createdBy;

	/**
	 * 수정자
	 */
	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;
}