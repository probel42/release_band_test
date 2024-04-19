package ru.ibelan.arkanoid.app.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.ibelan.arkanoid.app.dto.Stage
import ru.ibelan.arkanoid.app.dto.ScoreRequest
import ru.ibelan.arkanoid.app.model.ScoreItem
import ru.ibelan.arkanoid.app.service.StagesService
import ru.ibelan.arkanoid.app.service.ScoreService

@RestController
class ArkanoidController(
    val scoreService: ScoreService,
    val stagesService: StagesService
) {
    @PostMapping("score/send")
    fun sendScore(@RequestBody request: ScoreRequest) {
        scoreService.saveScore(request.user, request.score)
    }

    @GetMapping("score/board")
    fun getScoreBoard(): List<ScoreItem> {
        return scoreService.getScoreBoard()
    }

    @GetMapping("stage")
    fun getStage(@RequestParam number: Int): Stage? {
        return stagesService.getStage(number)
    }
}
