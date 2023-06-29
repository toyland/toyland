package com.project.toyland.common.error.handler;

import com.project.toyland.common.error.code.CommonErrorCode;
import com.project.toyland.common.error.code.ErrorCode;
import com.project.toyland.common.error.exception.ApiException;
import com.project.toyland.common.error.response.ErrorResponse;
import com.project.toyland.common.error.response.ErrorResponse.ValidationError;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 전역 예외 처리하는 exception handler
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException e) {
		final ErrorCode errorCode = e.getErrorCode();
		return handleExceptionInternal(errorCode);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException e) {
		log.warn("handleIllegalArgument", e);
		final ErrorCode errorCode = CommonErrorCode.INVALID_PARAMETER;
		return handleExceptionInternal(errorCode, e.getMessage());
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorResponse> handleAllException(Exception ex) {
		log.warn("handleAllException", ex);
		final ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
		return handleExceptionInternal(errorCode);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
		MethodArgumentNotValidException e,
		HttpHeaders headers,
		HttpStatus status,
		WebRequest request) {
		log.warn("handleMethodArgumentNotValid", e);
		final ErrorCode errorCode = CommonErrorCode.INVALID_PARAMETER;
		return handleExceptionInternal(e, errorCode);
	}

	private ResponseEntity<ErrorResponse> handleExceptionInternal(ErrorCode errorCode) {
		return ResponseEntity.status(errorCode.getHttpStatus())
			.body(makeErrorResponse(errorCode));
	}

	private ResponseEntity<ErrorResponse> handleExceptionInternal(ErrorCode errorCode, String message) {
		return ResponseEntity.status(errorCode.getHttpStatus())
			.body(makeErrorResponse(errorCode, message));
	}

	private ResponseEntity<ErrorResponse> handleExceptionInternal(BindException e, ErrorCode errorCode) {
		return ResponseEntity.status(errorCode.getHttpStatus())
			.body(makeErrorResponse(e, errorCode));
	}

	private ErrorResponse makeErrorResponse(ErrorCode errorCode) {
		return ErrorResponse.builder()
			.httpStatus(errorCode.getHttpStatus())
			.code(errorCode.getCode())
			.message(errorCode.getMessage())
			.build();
	}

	private ErrorResponse makeErrorResponse(ErrorCode errorCode, String message) {
		return ErrorResponse.builder()
			.httpStatus(errorCode.getHttpStatus())
			.code(errorCode.getCode())
			.message(message)
			.build();
	}

	private ErrorResponse makeErrorResponse(BindException e, ErrorCode errorCode) {
		List<ValidationError> validationErrorList = e.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(ErrorResponse.ValidationError::of)
			.collect(Collectors.toList());

		return ErrorResponse.builder()
			.httpStatus(errorCode.getHttpStatus())
			.code(errorCode.getCode())
			.message(errorCode.getMessage())
			.errors(validationErrorList)
			.build();
	}
}