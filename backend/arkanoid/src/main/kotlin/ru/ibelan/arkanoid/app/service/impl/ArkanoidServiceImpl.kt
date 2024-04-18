package ru.ibelan.arkanoid.app.service.impl

import org.springframework.stereotype.Service
import ru.ibelan.arkanoid.app.model.ScoreItem
import ru.ibelan.arkanoid.app.repository.ScoreRepository
import ru.ibelan.arkanoid.app.service.ArkanoidService
import java.time.LocalDateTime

@Service
class ArkanoidServiceImpl(
    val scoreRepository: ScoreRepository
) : ArkanoidService {
    override fun saveScore(user: String, score: Long) {
        val item = ScoreItem(user, score, LocalDateTime.now())
        scoreRepository.save(item)
    }

    override fun getScoreBoard(): List<ScoreItem> {
        // todo
        return emptyList()
    }
}
