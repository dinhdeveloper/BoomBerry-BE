package com.dinhtc.boomberry.controller

import com.dinhtc.boomberry.common.ResponseBuilder
import com.dinhtc.boomberry.service.ProductService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getAll(request: HttpServletRequest) =
        ResponseBuilder.success(
            body = productService.getAll(request)
        )

    @GetMapping("/category/{key}")
    fun getByCategory(
        @PathVariable key: String,
        request: HttpServletRequest
    ) =
        ResponseBuilder.success(
            body = productService.getByCategoryKey(key, request)
        )

    @GetMapping("/store")
    fun getProductSaleStore(request: HttpServletRequest) =
        ResponseBuilder.success(
            body = productService.getProductSaleStore(request)
        )
}
