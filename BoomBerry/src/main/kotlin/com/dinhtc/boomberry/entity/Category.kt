package com.dinhtc.boomberry.entity

import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val categoryId: Long? = null,

    @Column(name = "category_name", nullable = false)
    val categoryName: String,

    @Column(name = "category_image")
    val categoryImage: String? = null,

    @Column(name = "category_key", nullable = false, unique = true)
    val categoryKey: String
)
