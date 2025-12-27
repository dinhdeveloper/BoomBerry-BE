package com.dinhtc.boomberry.mapper

import com.dinhtc.boomberry.dto.ImageResponse
import com.dinhtc.boomberry.dto.ProductResponse
import com.dinhtc.boomberry.entity.ImageProduct
import com.dinhtc.boomberry.entity.Product
import jakarta.servlet.http.HttpServletRequest

fun Product.toResponse(request: HttpServletRequest): ProductResponse {
    val baseUrl = "${request.scheme}://${request.serverName}:${request.serverPort}"

    fun fullUrl(path: String?): String? {
        return path?.let {
            if (it.startsWith("http")) it else "$baseUrl/$it"
        }
    }

    return ProductResponse(
        productId = productId!!,
        productName = productName,
        productPrice = productPrice,
        productPriceSale = productPriceSale,
        productSalePercent = productSalePercent,
        productSoldCount = productSoldCount,
        productLocationSale = productLocationSale,
        categoryKey = categoryKey,
        imagesProduct = images
            .sortedWith(
                compareByDescending<ImageProduct> { it.isPrimary }
                    .thenBy { it.imageId }
            )
            .map {
                ImageResponse(
                    id = it.imageId,
                    imageUrl = fullUrl(it.imageUrl)!!,
                    isPrimary = it.isPrimary
                )
            },
    )
}