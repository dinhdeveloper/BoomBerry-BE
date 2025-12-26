package com.dinhtc.boomberry.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object ResponseBuilder {

    fun <T> success(
        body: T,
        description: String = "Success"
    ): ResponseEntity<ApiResponse<T>> {
        return ResponseEntity.ok(
            ApiResponse(
                resultCode = 0,
                codeStatus = HttpStatus.OK.value(),
                description = description,
                body = body
            )
        )
    }

    fun error(
        resultCode: Int = -99,
        status: HttpStatus,
        description: String
    ): ResponseEntity<ApiResponse<Nothing>> {
        return ResponseEntity.status(status).body(
            ApiResponse(
                resultCode = resultCode,
                codeStatus = status.value(),
                description = description,
                body = null
            )
        )
    }
}
