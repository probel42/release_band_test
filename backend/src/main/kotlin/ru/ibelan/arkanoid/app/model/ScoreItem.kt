package ru.ibelan.arkanoid.app.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "scores")
data class ScoreItem(
    val user: String,
    val score: Long,
    val date: LocalDateTime
)
