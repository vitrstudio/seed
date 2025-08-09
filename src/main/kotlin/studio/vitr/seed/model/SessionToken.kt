package studio.vitr.seed.model

import studio.vitr.seed.utils.TimeUtil

class SessionToken(
    val type: TokenType,
    val userId: String,
    val email: String?,
    val issuedAt: Long,
    val expiresAt: Long
) {
    fun isExpired() = TimeUtil.now() > expiresAt
}