package projeto.kotlin.Api.repository

import org.springframework.data.jpa.repository.JpaRepository
import projeto.kotlin.Api.models.Topico

interface topicoRepository: JpaRepository<Topico, Long> {
}