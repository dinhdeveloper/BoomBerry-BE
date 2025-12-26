package com.dinhtc.boomberry.common
data class ApiResponse<T>(
    val resultCode: Int,
    val codeStatus: Int,
    val description: String,
    val body: T?
)