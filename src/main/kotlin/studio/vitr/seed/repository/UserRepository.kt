package studio.vitr.seed.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import studio.vitr.seed.model.User
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, UUID>