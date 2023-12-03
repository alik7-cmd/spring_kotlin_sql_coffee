package com.tecascent.coffee.entity

import com.tecascent.coffee.common.BeverageType
import com.tecascent.coffee.common.BaseEntity
import jakarta.persistence.*

@Entity
@Access(AccessType.FIELD)
@Table(name = "Beverage")
data class BeverageEntity(
    var name: String,

    @Enumerated(EnumType.ORDINAL)
    var type: BeverageType,

    var price: String,
    var description: String,
    var imageUrl: String
) : BaseEntity()

