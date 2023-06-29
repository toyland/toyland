package com.project.toyland.common.error.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 공통 에러코드
 */
@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
	INVALID_PARAMETER("T001", HttpStatus.BAD_REQUEST, "포함된 매개변수가 잘못되었습니다."),
	RESOURCE_NOT_FOUND("T002", HttpStatus.NOT_FOUND, "해당 리소스가 존재하지 않습니다."),
	INTERNAL_SERVER_ERROR("T003", HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다."),
	INVALID_REQUEST("T004", HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
	;

	/**
	 * 정의한 에러코드
	 */
	private final String code;

	/**
	 * 에러 응답으로 반환할 HTTP 상태 코드
	 */
	private final HttpStatus httpStatus;

	/**
	 * 에러 응답으로 반환할 메세지
	 */
	private final String message;

}
