package com.project.toyland.common.error.exception;

import com.project.toyland.common.error.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;

/**
 * API 관련 custom exception
 */
@Getter
@RequiredArgsConstructor
public class ApiException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 300497546254862376L;

	/**
	 * 정의해둔 에러 코드
	 */
	private final ErrorCode errorCode;
}