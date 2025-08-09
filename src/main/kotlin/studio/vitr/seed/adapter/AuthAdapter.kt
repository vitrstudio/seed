package studio.vitr.seed.adapter

import org.springframework.stereotype.Component
import studio.vitr.seed.model.Session
import studio.vitr.seed.model.User
import studio.vitr.seed.model.api.RefreshTokenResponse
import studio.vitr.seed.model.api.SignInResponse
import studio.vitr.seed.model.api.SignUpRequest

@Component
class AuthAdapter {

    fun toSignUpResponse(s: Session) = SignInResponse(
        accessToken = s.accessToken,
        refreshToken = s.refreshToken,
    )

    fun toSignInResponse(s: Session) = SignInResponse(
        accessToken = s.accessToken,
        refreshToken = s.refreshToken,
    )

    fun toRefreshTokenResponse(s: Session) = RefreshTokenResponse(accessToken = s.accessToken)
}