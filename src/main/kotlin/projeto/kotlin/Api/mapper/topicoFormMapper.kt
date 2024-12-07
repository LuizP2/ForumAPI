package projeto.kotlin.Api.mapper

import org.springframework.stereotype.Component
import projeto.kotlin.Api.DTOs.forms.novoTopicoForm
import projeto.kotlin.Api.models.Topico
import projeto.kotlin.Api.services.CursoService
import projeto.kotlin.Api.services.UserService

@Component // ANOTAÇÂO IMPORTANTE PARA COMPONENTES
class topicoFormMapper(

    private val cursoService: CursoService,
    private val userService: UserService

): Mapper<novoTopicoForm, Topico> {
    override fun map(t: novoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.cursoPorID(t.idCurso),
            autor = userService.userPorID(t.idAutor)
        )
    }
}