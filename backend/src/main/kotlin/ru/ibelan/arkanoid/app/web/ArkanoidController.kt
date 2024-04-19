package ru.ibelan.arkanoid.app.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.ibelan.arkanoid.app.dto.Level
import ru.ibelan.arkanoid.app.dto.ScoreRequest
import ru.ibelan.arkanoid.app.model.ScoreItem
import ru.ibelan.arkanoid.app.service.LevelsService
import ru.ibelan.arkanoid.app.service.ScoreService

@RestController
class ArkanoidController(
    val scoreService: ScoreService,
    val levelsService: LevelsService
) {
    @PostMapping("score/send")
    fun sendScore(@RequestBody request: ScoreRequest) {
        scoreService.saveScore(request.user, request.score)
    }

    @GetMapping("score/board")
    fun getScoreBoard(): List<ScoreItem> {
        return scoreService.getScoreBoard()
    }

    @GetMapping("level")
    fun getLevel(@RequestParam number: Int): Level? {
        return levelsService.getLevel(number)
    }
}
