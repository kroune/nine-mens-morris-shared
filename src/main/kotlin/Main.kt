package com.kroune

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class NetworkResponse(
    @Suppress("unused") val code: Int,
    @Suppress("unused") val message: String?
) {
    fun encode(): String {
        return Json.encodeToString<NetworkResponse>(this@NetworkResponse)
    }
}

sealed class ApiException: Exception() {
    class InvalidJwtToken: ApiException()
    class InvalidCredentials: ApiException()
    class IncorrectGameId: ApiException()
    class InvalidMove: ApiException()
    class IllegalMove: ApiException()
    class BadLogin: ApiException()
    class BadPassword: ApiException()
    class LoginInUse: ApiException()
    class Internal: ApiException()
}