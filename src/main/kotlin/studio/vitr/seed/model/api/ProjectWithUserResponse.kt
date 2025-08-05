package studio.vitr.seed.model.api

import studio.vitr.seed.model.ProjectType
import java.util.*

class ProjectWithUserResponse(
    val id: UUID,
    val name: String,
    val type: ProjectType,
    val user : UserResponse
)
