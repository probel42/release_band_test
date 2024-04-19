package ru.ibelan.arkanoid.app.service

import ru.ibelan.arkanoid.app.dto.Stage

interface StagessService {
    fun getStage(number: Int): Stage?
}
