package studio.vitr.seed.model.api

import studio.vitr.seed.model.ProjectType

class ProjectRequest(
    val name: String,
    val type: ProjectType,
)