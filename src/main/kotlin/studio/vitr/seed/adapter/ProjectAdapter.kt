package studio.vitr.seed.adapter

import org.springframework.stereotype.Component
import studio.vitr.seed.constants.Properties.ID
import studio.vitr.seed.errors.InvalidParameter
import studio.vitr.seed.model.Project
import studio.vitr.seed.model.User
import studio.vitr.seed.model.api.ProjectRequest
import studio.vitr.seed.model.api.ProjectResponse
import studio.vitr.seed.model.api.ProjectWithUserResponse

@Component
class ProjectAdapter(
    private val userAdapter: UserAdapter,
) {
    fun toProject(request: ProjectRequest, user: User, githubRepositoryId: Long) = Project(
        name = request.name,
        type = request.type,
        githubRepositoryId = githubRepositoryId,
        user = user
    )

    fun toProjectResponse(project: Project) = ProjectResponse(
        id = project.id ?: throw InvalidParameter(ID),
        name = project.name,
        type = project.type,
        createdAt = project.createdAt,
    )

    fun toProjectWithUserResponse(project: Project, user: User) = ProjectWithUserResponse(
        id = project.id ?: throw InvalidParameter(ID),
        name = project.name,
        type = project.type,
        user = userAdapter.toUserResponse(user)
    )
} 