package com.kroune

import com.kr8ne.mensMorris.Position
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

@Serializable
sealed class GameSignals(val serverMessage: String) {
    @Serializable
    class Move(val message: String) : GameSignals(message)
    @Serializable
    class GameEnd(val message: String) : GameSignals(message)
    @Serializable
    class MoveTurn(val boolean: Boolean): GameSignals("this is move turn class, no message available")
    @Serializable
    class PositionInfo(val pos: Position) : GameSignals("this is pos info class, no message available")
}
