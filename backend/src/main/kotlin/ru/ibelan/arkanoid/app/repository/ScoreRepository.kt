package ru.ibelan.arkanoid.app.repository


import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.ibelan.arkanoid.app.model.ScoreItem

@Repository
interface ScoreRepository : MongoRepository<ScoreItem, String> {
    @Aggregation(pipeline = [
        "{ '\$sort' : { 'score' : -1 } }",
        "{ '\$limit' : ?0 }"
    ])
    fun getTopByScore(limit: Int): List<ScoreItem>
}
