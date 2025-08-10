package studio.vitr.seed.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import studio.vitr.seed.constants.Properties.USER_ID
import studio.vitr.seed.errors.MissingExpectedParameter
import studio.vitr.seed.utils.TimeUtil
import java.util.*
import jakarta.persistence.GenerationType.UUID as UUIDX

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = UUIDX) val id: UUID? = null,
    val email: String,
    val password: String,
    val createdAt: Long = TimeUtil.now(),
) {
    fun idStr() = id?.toString() ?: throw MissingExpectedParameter(USER_ID)
}
