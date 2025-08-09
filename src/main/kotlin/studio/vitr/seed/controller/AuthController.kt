package studio.vitr.seed.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import studio.vitr.seed.adapter.AuthAdapter
import studio.vitr.seed.model.api.RefreshTokenRequest
import studio.vitr.seed.model.api.SignInRequest
import studio.vitr.seed.model.api.SignUpRequest
import studio.vitr.seed.service.AuthenticationService

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthenticationService,
    private val adapter: AuthAdapter,
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest) = authService
        .signUp(request)
        .let { adapter.toSignUpResponse(it) }

    @PostMapping("/signin")
    fun signIn(@RequestBody request: SignInRequest) = authService
        .signIn(request)
        .let { adapter.toSignInResponse(it) }

    @PostMapping("/refresh")
    fun refreshToken(@RequestBody request: RefreshTokenRequest) = authService
        .refreshToken(request)
        .let { adapter.toRefreshTokenResponse(it) }
}
