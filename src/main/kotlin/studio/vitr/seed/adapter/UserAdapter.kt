package studio.vitr.seed.adapter

import org.springframework.stereotype.Component
import studio.vitr.seed.constants.Properties.ID
import studio.vitr.seed.errors.InvalidParameter
import studio.vitr.seed.model.User
import studio.vitr.seed.model.api.CreateUserRequest
import studio.vitr.seed.model.api.UserResponse
import studio.vitr.seed.service.PasswordEncoderService

@Component
class UserAdapter(
    private val passwordEncoderService: PasswordEncoderService
) {

    fun toUser(r: CreateUserRequest) = User(
        email = r.email,
        password = passwordEncoderService.encodePassword(r.password),
    )

    fun toUserResponse(u: User) = UserResponse(
        id = u.id ?: throw InvalidParameter(ID),
        email = u.email,
        createdAt = u.createdAt,
    )
}