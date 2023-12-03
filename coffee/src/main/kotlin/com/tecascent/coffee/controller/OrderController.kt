package com.tecascent.coffee.controller

import com.tecascent.coffee.entity.OrderEntity
import com.tecascent.coffee.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/order")
class OrderController @Autowired constructor(@Qualifier("orderServiceImpl") val service: OrderService) : OrderService {
    @PostMapping
    override fun create(@RequestBody entity: OrderEntity) = service.create(entity)

    @PutMapping("/{id}")
    override fun update(@PathVariable id: Long, entity: OrderEntity) = service.update(id, entity)

    @GetMapping("/{id}")
    override fun findById(id: Long) = service.findById(id)

    @GetMapping
    override fun findAll() = service.findAll()

    @DeleteMapping("/{id}")
    override fun deleteById(id: Long) = service.deleteById(id)
}