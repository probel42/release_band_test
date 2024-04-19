package ru.ibelan.arkanoid.app.service.impl

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import ru.ibelan.arkanoid.app.dto.Stage
import ru.ibelan.arkanoid.app.service.StagesService

@Service
class StagesServiceImpl : StagesService {
    companion object {
        private const val STAGES_INFO_PATH = "stages/stages.json"
        private const val BASE_SPEED: Int = 10
        private const val SPEED_INCREASE: Double = 0.5 // 50%

        val stages: List<Stage>

        init {
            val objectMapper = ObjectMapper()
            ClassPathResource(STAGES_INFO_PATH).inputStream.use { inputStream ->
                stages = objectMapper.readValue(inputStream, object : TypeReference<List<String>>() {})
                    .map { Stage(it, 0.0) }
            }
        }
    }

    override fun getStage(number: Int): Stage? {
        if (number <= 0) {
            return null
        }
        val speed = BASE_SPEED + BASE_SPEED * SPEED_INCREASE * (number / stages.size)
        return stages[number % stages.size].copy(speed = speed)
    }
}
