package ru.ibelan.arkanoid.app.service

import ru.ibelan.arkanoid.app.dto.Level

interface LevelsService {
    fun getLevel(number: Int): Level?
}
