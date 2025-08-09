package studio.vitr.seed.adapter

import org.springframework.stereotype.Component
import studio.vitr.seed.constants.Properties.ID
import studio.vitr.seed.errors.InvalidParameter
import studio.vitr.seed.model.User
import studio.vitr.seed.model.api.UserResponse

@Component
class UserAdapter {
    fun toUserResponse(u: User) = UserResponse(
        id = u.id ?: throw InvalidParameter(ID),
        email = u.email,
        createdAt = u.createdAt,
    )
}