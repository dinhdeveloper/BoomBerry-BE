package com.dinhtc.boomberry.mapper

import com.dinhtc.boomberry.dto.CategoryResponse
import com.dinhtc.boomberry.entity.Category
import jakarta.servlet.http.HttpServletRequest

fun Category.toResponse(request: HttpServletRequest): CategoryResponse {

    val baseUrl = "${request.scheme}://${request.serverName}:${request.serverPort}"

    return CategoryResponse(
        categoryId = categoryId!!,
        categoryKey = categoryKey,
        categoryName = categoryName,
        categoryImage = categoryImage?.let { "$baseUrl/$it" }
    )
}
