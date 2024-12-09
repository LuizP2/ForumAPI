package projeto.kotlin.Api.repository

import org.springframework.data.jpa.repository.JpaRepository
import projeto.kotlin.Api.models.Topico
import projeto.kotlin.Api.models.Usuario
import projeto.kotlin.Api.models.curso

interface usuarioRepository: JpaRepository<Usuario, Long> {
}