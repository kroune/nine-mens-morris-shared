package com.kroune.nineMensMorrisShared

import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString

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

sealed class GameEndReason(val isFirstUser: Boolean) {
    class UserGaveUp(isFirstUserWon: Boolean) : GameEndReason(isFirstUserWon)
    class UserWasTooSlow(isFirstUserWon: Boolean) : GameEndReason(isFirstUserWon)
    class Normal(isFirstUserWon: Boolean) : GameEndReason(isFirstUserWon)
}
