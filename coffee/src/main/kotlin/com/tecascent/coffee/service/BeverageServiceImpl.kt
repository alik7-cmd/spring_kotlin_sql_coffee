package com.tecascent.coffee.service

import com.tecascent.coffee.entity.BeverageEntity
import com.tecascent.coffee.repository.BeverageRepository
import jakarta.persistence.EntityNotFoundException
import org.hibernate.service.spi.ServiceException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class BeverageServiceImpl @Autowired constructor(@Lazy private val repository: BeverageRepository) : BeverageService {

    companion object{
        const val ERROR_MESSAGE = "Beverage not found."
    }

    override fun create(entity: BeverageEntity): BeverageEntity {
        try {
            return repository.save(entity)
        } catch (e: Exception) {
            throw ServiceException("Error persisting a new Message", e)
        }
    }

    override fun update(id: Long, entity: BeverageEntity): BeverageEntity {
        try {
            val persistedEntity = repository.findById(id).orElseThrow { EntityNotFoundException(ERROR_MESSAGE + id) }
            updateFields(persistedEntity, entity)
            persistedEntity.id = id
            return repository.save(persistedEntity)
        } catch (e: Exception) {
            throw ServiceException("Error updating a Message", e)
        }
    }

    override fun findById(id: Long): BeverageEntity {
        return repository.findById(id).orElseThrow { EntityNotFoundException(ERROR_MESSAGE + id) }

    }

    override fun findAll(): List<BeverageEntity> {
        try {
            val beverageList = repository.findAll()
            return beverageList.toList()
        } catch (e: Exception) {
            throw ServiceException("Error retrieving all existing messages", e)
        }
    }

    override fun deleteById(id: Long) {
        repository.findById(id).orElseThrow { EntityNotFoundException(ERROR_MESSAGE + id) }
        try {
            repository.deleteById(id)
        } catch (e: DataIntegrityViolationException) {
            //log.error("Error deleting Message with id: " + id + " - " + e.message, e)
        }
    }

    private fun updateFields(persistedEntity: BeverageEntity, newEntity: BeverageEntity) {

        persistedEntity.apply {
            name = newEntity.name
            type = newEntity.type
            price = newEntity.price
            description = newEntity.description
            imageUrl = newEntity.imageUrl
        }
    }
}