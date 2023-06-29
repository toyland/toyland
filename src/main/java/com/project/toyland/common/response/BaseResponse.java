package com.project.toyland.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

/**
 * API 공통 응답 DTO
 *
 * @param <T> data(응답값)
 */
@Schema(description = "API 공통 응답 DTO")
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값을 가지는 속성을 JSON 출력에 포함 x
public class BaseResponse<T> {

	/**
	 * 요청 성공 여부
	 */
	@Schema(description = "요청 성공 여부 (SUCCESS: 요청 성공, FAILURE: 요청 실패)", example = "SUCCESS")
	private String result;

	/**
	 * HTTP Status code
	 */
	@Schema(description = "HTTP Status code", example = "200")
	private String code;

	/**
	 * 요청 결과에 대한 메세지
	 */
	@Schema(description = "요청 결과에 대한 메세지", example = "요청이 성공하였습니다.")
	private String message;

	/**
	 * 요청 결과 데이터
	 */
	@Schema(description = "요청 결과 데이터")
	private T data;

	@Builder
	public BaseResponse(String result, String code, String message, T data) {
		this.result = result;
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
