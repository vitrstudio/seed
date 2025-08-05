package studio.vitr.seed.controller

import org.springframework.web.bind.annotation.*
import studio.vitr.seed.adapter.UserAdapter
import studio.vitr.seed.constants.Properties.USER
import studio.vitr.seed.errors.NotFound
import studio.vitr.seed.model.api.UserRequest
import studio.vitr.seed.service.UserService
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val userAdapter: UserAdapter,
) {

    @GetMapping
    fun getUsers() = userService.getAll()
        .map { userAdapter.toUserResponse(it) }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: UUID) = userService.get(userId)
        ?.let { userAdapter.toUserResponse(it) }
        ?: throw NotFound(USER, userId.toString())

    @PostMapping
    fun createUser(@RequestBody request: UserRequest) = userAdapter
        .toUser(request)
        .let { userService.create(it) }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: UUID) = userService.delete(userId)
}