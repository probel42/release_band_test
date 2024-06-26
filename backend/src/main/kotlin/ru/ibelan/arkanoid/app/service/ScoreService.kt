package ru.ibelan.arkanoid.app.service

import ru.ibelan.arkanoid.app.model.ScoreItem

interface ScoreService {
    fun saveScore(user: String, score: Long)
    fun getScoreBoard(): List<ScoreItem>
}
