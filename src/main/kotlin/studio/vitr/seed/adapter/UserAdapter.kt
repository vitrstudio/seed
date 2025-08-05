package studio.vitr.seed.adapter

import org.springframework.stereotype.Component
import studio.vitr.seed.constants.Properties.ID
import studio.vitr.seed.errors.InvalidParameter
import studio.vitr.seed.model.User
import studio.vitr.seed.model.api.UserRequest
import studio.vitr.seed.model.api.UserResponse

@Component
class UserAdapter {

    fun toUser(request: UserRequest) = User(
        githubUserId = request.githubUserId
    )

    fun toUserResponse(user: User) = UserResponse(
        id = user.id ?: throw InvalidParameter(ID),
        githubUserId = user.githubUserId,
        createdAt = user.createdAt,
    )
}