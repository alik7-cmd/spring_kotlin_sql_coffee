package com.tecascent.coffee.entity

import com.tecascent.coffee.common.BaseEntity
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "table_order")
data class OrderEntity(
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "beverage_id", referencedColumnName = "id")
    var beverage: BeverageEntity,

    /*@ElementCollection
    @CollectionTable(name = "order_decorators", joinColumns = [JoinColumn(name = "order_id")])
    @Column(name = "decorator", nullable = false)
    var decorators: List<Decorator>*/
    @ElementCollection
    @CollectionTable(name = "order_decorators", joinColumns = [JoinColumn(name = "order_id")])
    var decorators: List<Decorator>,

    var totalPrice : Double

) : BaseEntity(), Serializable


