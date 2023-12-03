package com.tecascent.coffee.controller

import com.tecascent.coffee.entity.BeverageEntity
import org.springframework.beans.factory.annotation.Autowired
import com.tecascent.coffee.service.BeverageService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/beverage")
class BeverageController @Autowired constructor(@Qualifier("beverageServiceImpl") val service: BeverageService) : BeverageService {
    @PostMapping
    override fun create(@RequestBody entity: BeverageEntity) = service.create(entity)

    @PutMapping("/{id}")
    override fun update(@PathVariable id: Long, entity: BeverageEntity) = service.update(id, entity)

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long) = service.findById(id)

    @GetMapping
    override fun findAll() = service.findAll()

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long) = service.deleteById(id)
}