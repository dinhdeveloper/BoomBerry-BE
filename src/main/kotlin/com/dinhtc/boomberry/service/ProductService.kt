package com.dinhtc.boomberry.service

import com.dinhtc.boomberry.dto.ProductResponse
import com.dinhtc.boomberry.mapper.toResponse
import com.dinhtc.boomberry.repository.ProductRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryService: CategoryService
) {

    fun getAll(request: HttpServletRequest) =
        productRepository.findAll()
            .map { it.toResponse(request) }

    fun getByCategoryKey(categoryKey: String, request: HttpServletRequest): List<ProductResponse> {

        // Nếu ALL → trả về tất cả
        if (categoryKey.equals("ALL", ignoreCase = true)) {
            return productRepository.findAll()
                .map { it.toResponse(request) }
        }

        // Validate categoryKey tồn tại
        categoryService.validateCategoryKey(categoryKey)

        // Query sản phẩm theo categoryKey
        return productRepository.findByCategoryKeyIgnoreCase(categoryKey)
            .map { it.toResponse(request) }
    }

    fun getProductSaleStore(request: HttpServletRequest) =
        productRepository.findByProductLocationSale("STORE")
            .map { it.toResponse(request) }

}
