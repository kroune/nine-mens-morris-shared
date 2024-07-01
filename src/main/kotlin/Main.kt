package com.kroune

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

@Deprecated("it will be replaced with purpose specific classes")
@Serializable
class NetworkResponse(
    @Suppress("unused") val code: Int,
    @Suppress("unused") val message: String?
) {
    fun encode(): String {
        return Json.encodeToString<NetworkResponse>(this@NetworkResponse)
    }
}

@Serializable
class GameResponse(
    val message: String,
    val counter: Int
) {
    fun encode(): String {
        return Json.encodeToString<GameResponse>(this@GameResponse)
    }
}

sealed class GameSignals(message: String) {
    class Move(message: String) : GameSignals(message)
    class GameEnd(message: String) : GameSignals(message)
}