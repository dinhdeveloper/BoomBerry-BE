package com.dinhtc.boomberry.exception

import com.dinhtc.boomberry.common.ApiResponse
import com.dinhtc.boomberry.common.ResponseBuilder
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    // 404 - Not Found
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(ex: NotFoundException): ResponseEntity<ApiResponse<Nothing>> {
        return ResponseBuilder.error(
            status = HttpStatus.NOT_FOUND,
            description = ex.message ?: "Resource not found"
        )
    }

    // 400 - Bad Request
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequest(ex: BadRequestException): ResponseEntity<ApiResponse<Nothing>> {
        return ResponseBuilder.error(
            status = HttpStatus.BAD_REQUEST,
            description = ex.message ?: "Bad request"
        )
    }

    // Validation error (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<ApiResponse<Map<String, String>>> {

        val errors = ex.bindingResult.fieldErrors.associate {
            it.field to (it.defaultMessage ?: "Invalid value")
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ApiResponse(
                resultCode = -99,
                codeStatus = HttpStatus.BAD_REQUEST.value(),
                description = "Validation error",
                body = errors
            )
        )
    }

    // Catch-all (500)
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ApiResponse<Nothing>> {
        log.error("Unhandled exception", ex)

        return ResponseBuilder.error(
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            description = "Internal server error"
        )
    }
}