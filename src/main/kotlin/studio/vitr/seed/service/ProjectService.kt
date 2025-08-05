package studio.vitr.seed.service

import org.springframework.stereotype.Service
import studio.vitr.seed.adapter.ProjectAdapter
import studio.vitr.seed.integrations.GithubClient
import studio.vitr.seed.model.Project
import studio.vitr.seed.model.User
import studio.vitr.seed.model.api.ProjectRequest
import studio.vitr.seed.repository.ProjectRepository
import java.util.*

@Service
class ProjectService(
    private val projectRepository: ProjectRepository,
    private val githubClient: GithubClient,
    private val adapter: ProjectAdapter,
) {

    fun getAll(): List<Project> = projectRepository.findAll()

    fun getByUserId(userId: UUID) = projectRepository.findByUserId(userId)

    fun create(user: User, request: ProjectRequest) =  githubClient
        .createRepository(user.githubUserId, request.name)
        .let { adapter.toProject(request, user, it) }
        .let { projectRepository.save(it) }

    fun delete(id: UUID) = projectRepository.deleteById(id)
}