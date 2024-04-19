package ru.ibelan.arkanoid.app.service.impl

import org.springframework.stereotype.Service
import ru.ibelan.arkanoid.app.model.ScoreItem
import ru.ibelan.arkanoid.app.repository.ScoreRepository
import ru.ibelan.arkanoid.app.service.ScoreService
import java.time.LocalDateTime

@Service
class ScoreServiceImpl(
    val scoreRepository: ScoreRepository
) : ScoreService {
    companion object {
        val SCORE_TOP_LIMIT = 5
    }

    override fun saveScore(user: String, score: Long) {
        val item = ScoreItem(user, score, LocalDateTime.now())
        scoreRepository.save(item)
    }

    override fun getScoreBoard(): List<ScoreItem> {
        return scoreRepository.getTopByScore(SCORE_TOP_LIMIT)
    }
}
