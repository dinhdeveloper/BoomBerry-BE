package com.dinhtc.boomberry.service

import com.dinhtc.boomberry.dto.CategoryResponse
import com.dinhtc.boomberry.entity.Category
import com.dinhtc.boomberry.exception.NotFoundException
import com.dinhtc.boomberry.mapper.toResponse
import com.dinhtc.boomberry.repository.CategoryRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun getAllCategories(request: HttpServletRequest): List<CategoryResponse> =
        categoryRepository.findAll().map {
            it.toResponse(request)
        }

    fun getByKey(key: String, request: HttpServletRequest): CategoryResponse =
        categoryRepository.findByCategoryKey(key)
            .orElseThrow { RuntimeException("Category not found") }
            .toResponse(request)

    fun validateCategoryKey(categoryKey: String): Category {
        return categoryRepository.findByCategoryKey(categoryKey.uppercase())
            .orElseThrow { NotFoundException("Category with key '$categoryKey' not found") }
    }
}
