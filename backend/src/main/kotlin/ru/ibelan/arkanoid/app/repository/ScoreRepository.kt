package ru.ibelan.arkanoid.app.repository


import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.ibelan.arkanoid.app.model.ScoreItem

@Repository
interface ScoreRepository : MongoRepository<ScoreItem, String> {
    fun getTop(): List<ScoreItem>
}
