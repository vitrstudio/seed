package studio.vitr.seed.model

import studio.vitr.seed.constants.Properties.TOKEN_TYPE
import studio.vitr.seed.errors.InvalidEnumValue

enum class TokenType {
    ACCESS,
    REFRESH;

    companion object {
        fun fromString(value: String) = entries
            .find { it.toString() == value }
            ?: throw InvalidEnumValue(TOKEN_TYPE, value)
    }
}