package studio.vitr.seed.model

class Session(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long
)