package com.dinhtc.boomberry.mapper

import com.dinhtc.boomberry.dto.ProductResponse
import com.dinhtc.boomberry.entity.Product
import jakarta.servlet.http.HttpServletRequest

fun Product.toResponse(request: HttpServletRequest): ProductResponse {
    val baseUrl = "${request.scheme}://${request.serverName}:${request.serverPort}"

    val imageUrl = productImage?.let {
        if (it.startsWith("http")) it else "$baseUrl/$it"
    }

    return ProductResponse(
        productId = productId!!,
        productName = productName,
        productImage = imageUrl,
        productPrice = productPrice,
        productPriceSale = productPriceSale,
        productSalePercent = productSalePercent,
        productSoldCount = productSoldCount,
        productLocationSale = productLocationSale,
        categoryKey = categoryKey
    )
}
