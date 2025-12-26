package com.dinhtc.boomberry.repository

import com.dinhtc.boomberry.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {

    fun findByCategoryKey(categoryKey: String): List<Product>

    fun findByProductLocationSale(location: String): List<Product>

    fun findByCategoryKeyIgnoreCase(categoryKey: String): List<Product>
}
