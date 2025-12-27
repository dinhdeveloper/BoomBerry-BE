package com.dinhtc.boomberry.entity

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    val productId: Long? = null,

    @Column(name = "category_id", nullable = false)
    val categoryId: Long,

    @Column(name = "product_name", nullable = false)
    val productName: String,

    @Column(name = "product_price", nullable = false)
    val productPrice: Double,

    @Column(name = "product_price_sale")
    val productPriceSale: Double? = null,

    @Column(name = "product_sale_percent")
    val productSalePercent: Int = 0,

    @Column(name = "product_sold_count")
    val productSoldCount: Int = 0,

    @Column(name = "product_location_sale")
    val productLocationSale: String? = null,

    @Column(name = "category_key", nullable = false)
    val categoryKey: String,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    val images: List<ImageProduct> = mutableListOf()

)
