package com.dinhtc.boomberry.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "image_product")
class ImageProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val imageId: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    val imageUrl: String,
    val isPrimary: Boolean = false
)
