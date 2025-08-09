package studio.vitr.seed.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import studio.vitr.seed.model.api.Health
import studio.vitr.seed.model.api.HealthStatus

@RestController
class HealthController(
    @Value("\${spring.application.version}")
    private val appVersion: String
) {

    @GetMapping("/health")
    fun health() = Health(HealthStatus.UP, appVersion)
}
