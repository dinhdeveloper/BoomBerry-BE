package com.dinhtc.boomberry.controller

import com.dinhtc.boomberry.common.ResponseBuilder
import com.dinhtc.boomberry.service.CategoryService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    fun getAll(request: HttpServletRequest) =
        ResponseBuilder.success(
            body = categoryService.getAllCategories(request)
        )

    @GetMapping("/{key}")
    fun getByKey(
        @PathVariable key: String,
        request: HttpServletRequest
    ) =
        ResponseBuilder.success(
            body = categoryService.getByKey(key, request)
        )
}