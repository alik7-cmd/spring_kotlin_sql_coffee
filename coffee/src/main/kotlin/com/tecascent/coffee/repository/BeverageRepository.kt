package com.tecascent.coffee.repository

import com.tecascent.coffee.entity.BeverageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BeverageRepository : JpaRepository<BeverageEntity, Long> {
}