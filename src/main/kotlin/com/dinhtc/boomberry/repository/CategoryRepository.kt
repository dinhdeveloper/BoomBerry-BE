package com.dinhtc.boomberry.repository


import com.dinhtc.boomberry.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CategoryRepository : JpaRepository<Category, Int> {

    fun findByCategoryKey(categoryKey: String): Optional<Category>
}