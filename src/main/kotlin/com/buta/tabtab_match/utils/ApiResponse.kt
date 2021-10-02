package com.buta.tabtab_match.utils

class ApiResponse<S>(
    val resultType: ResultType,
    val result: S? = null,
    val errorMessage: String? = null
) {
    companion object {
        fun <S> success(result: S?): ApiResponse<S> {
            return ApiResponse(ResultType.SUCCESS, result)
        }

        fun <S> error(result: S?, message: String?): ApiResponse<S> {
            return ApiResponse(ResultType.FAIL, result, message)
        }
    }
}

enum class ResultType {
    SUCCESS,
    FAIL
}