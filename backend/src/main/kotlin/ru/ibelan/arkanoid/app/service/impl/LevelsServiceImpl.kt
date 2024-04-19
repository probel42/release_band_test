package ru.ibelan.arkanoid.app.service.impl

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import ru.ibelan.arkanoid.app.dto.Level
import ru.ibelan.arkanoid.app.service.LevelsService

@Service
class LevelsServiceImpl : LevelsService {
    companion object {
        private const val LEVELS_PATH = "levels/levels.json"
        private const val BASE_SPEED: Int = 10
        private const val SPEED_INCREASE: Double = 0.5 // 50%

        val levels: List<Level>

        init {
            val objectMapper = ObjectMapper()
            ClassPathResource(LEVELS_PATH).inputStream.use { inputStream ->
                levels = objectMapper.readValue(inputStream, object : TypeReference<List<String>>() {})
                    .map { Level(it, 0.0) }
            }
        }
    }

    override fun getLevel(number: Int): Level? {
        if (number <= 0) {
            return null
        }
        val speed = BASE_SPEED + BASE_SPEED * SPEED_INCREASE * (number / levels.size)
        return levels[number % levels.size].copy(speed = speed)
    }
}
