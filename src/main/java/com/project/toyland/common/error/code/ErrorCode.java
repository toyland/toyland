package com.project.toyland.common.error.code;

import org.springframework.http.HttpStatus;

/**
 * 에러코드 인터페이스
 */
public interface ErrorCode {

	/**
	 * 정의한 에러코드 반환
	 * @return 에러코드
	 */
	String getCode();

	/**
	 * 에러 응답으로 반환할 HTTP 상태코드 반환
	 * @return HTTP 상태코드
	 */
	HttpStatus getHttpStatus();

	/**
	 * 에러 응답 메세지 반환
	 * @return 에러 응답 메세지
	 */
	String getMessage();
}