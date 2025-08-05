package studio.vitr.seed.model.api

import studio.vitr.seed.model.ProjectType
import java.util.UUID

class ProjectResponse(
    val id: UUID,
    val name: String,
    val type: ProjectType,
    val createdAt: Long
)