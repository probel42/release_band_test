package ru.ibelan.arkanoid.app.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.ibelan.arkanoid.app.dto.ScoreRequest
import ru.ibelan.arkanoid.app.model.ScoreItem
import ru.ibelan.arkanoid.app.service.ArkanoidService

@RestController
class ArkanoidController(
    val arkanoidService: ArkanoidService
) {
    @PostMapping("score/send")
    fun sendScore(@RequestBody request: ScoreRequest) {
        arkanoidService.saveScore(request.user, request.score)
    }

    @GetMapping("score/board")
    fun getScoreBoard(): List<ScoreItem> {
        return arkanoidService.getScoreBoard()
    }
}
