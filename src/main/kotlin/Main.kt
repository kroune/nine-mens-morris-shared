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