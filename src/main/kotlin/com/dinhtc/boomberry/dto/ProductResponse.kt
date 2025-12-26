package com.dinhtc.boomberry.dto

data class ProductResponse(
    val productId: Long,
    val productName: String,
    val productImage: String?,
    val productPrice: Double,
    val productPriceSale: Double?,
    val productSalePercent: Int,
    val productSoldCount: Int,
    val productLocationSale: String?,
    val categoryKey: String
)
