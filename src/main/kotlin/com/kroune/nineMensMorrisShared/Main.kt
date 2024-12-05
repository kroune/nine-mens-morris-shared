package com.kroune.nineMensMorrisShared

import kotlinx.serialization.Serializable

@Serializable
sealed class GameEndReason(val isFirstUser: Boolean?) {
    @Serializable
    data class UserGaveUp(val isFirstUserWon: Boolean) : GameEndReason(isFirstUserWon)
    @Serializable
    data class UserWasTooSlow(val isFirstUserWon: Boolean) : GameEndReason(isFirstUserWon)
    @Serializable
    data class Normal(val isFirstUserWon: Boolean) : GameEndReason(isFirstUserWon)
    @Serializable
    class Aborted : GameEndReason(null)
}
