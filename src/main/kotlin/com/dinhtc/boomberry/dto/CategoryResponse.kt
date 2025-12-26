package com.dinhtc.boomberry.dto

data class CategoryResponse(
    val categoryId: Long,
    val categoryKey: String,
    val categoryName: String,
    val categoryImage: String?
)
