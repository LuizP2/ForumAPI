package projeto.kotlin.Api.repository

import org.springframework.data.jpa.repository.JpaRepository
import projeto.kotlin.Api.models.Usuario

interface usuarioRepository: JpaRepository<Usuario, Long> {
}