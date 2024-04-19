package ru.ibelan.arkanoid.app.service

import ru.ibelan.arkanoid.app.dto.Stage

interface StagesService {
    fun getStage(number: Int): Stage?
}
