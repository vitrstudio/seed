package studio.vitr.seed.service

import org.springframework.stereotype.Service
import studio.vitr.seed.constants.Properties.USER
import studio.vitr.seed.errors.NotFound
import studio.vitr.seed.model.User
import studio.vitr.seed.repository.UserRepository
import java.util.UUID

@Service
class UserService(val userRepository: UserRepository) {

    fun getAll(): List<User> = userRepository.findAll()

    fun get(id: UUID): User? = userRepository
        .findById(id)
        .orElse(null)

    fun create(user: User) = userRepository.save(user)

    fun delete(userId: UUID) = get(userId)
        ?.let { userRepository.delete(it) }
        ?: throw NotFound(USER, userId.toString())
}