package projeto.kotlin.Api.services

import org.springframework.stereotype.Service
import projeto.kotlin.Api.DTOs.novoTopicoForm
import projeto.kotlin.Api.DTOs.topicoView
import projeto.kotlin.Api.models.topico
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class topicoService (
    private var topicos: List<topico> = ArrayList(),
    private val cursoService: CursoService,
    private val userService: UserService
    ) {

    fun listarTopicos(): List<topicoView> {
        return topicos.stream().map { t -> topicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        ) }.collect(Collectors.toList())

    }

    fun IDlist(id: Long): topicoView {
        val topico = topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()

        return topicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )
    }

    fun cadastrar(DTOs: novoTopicoForm) {
        topicos = topicos.plus(topico(
            id = topicos.size.toLong()+1,
            titulo = DTOs.titulo,
            mensagem = DTOs.mensagem,
            curso = cursoService.cursoPorID(DTOs.idCurso),
            autor = userService.userPorID(DTOs.idAutor)
        ))
    }


}