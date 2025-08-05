package studio.vitr.seed.controller

import org.springframework.web.bind.annotation.*
import studio.vitr.seed.adapter.ProjectAdapter
import studio.vitr.seed.constants.Properties.USER
import studio.vitr.seed.errors.NotFound
import studio.vitr.seed.model.api.ProjectRequest
import studio.vitr.seed.model.api.ProjectResponse
import studio.vitr.seed.service.ProjectService
import studio.vitr.seed.service.UserService
import java.util.*

@RestController
@RequestMapping("/users/{userId}/projects")
class UserProjectController(
    private val userService: UserService,
    private val projectService: ProjectService,
    private val projectAdapter: ProjectAdapter,
) {

    @GetMapping
    fun getProjects(@PathVariable userId: UUID)= projectService.getByUserId(userId)
        .map { projectAdapter.toProjectResponse(it) }

    @PostMapping
    fun createProject(
        @PathVariable userId: UUID,
        @RequestBody request: ProjectRequest,
    ): ProjectResponse {
        val user = userService.get(userId) ?: throw NotFound(USER, userId.toString())
        return projectService.create(user, request)
            .let { projectAdapter.toProjectResponse(it) }
    }

    @DeleteMapping("/{projectId}")
    fun deleteProject(
        @PathVariable userId: UUID,
        @PathVariable projectId: UUID
    ) = projectService.delete(projectId)
}