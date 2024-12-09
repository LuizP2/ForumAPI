package projeto.kotlin.Api.services

import org.springframework.stereotype.Service
import projeto.kotlin.Api.DTOs.forms.AttTopicoform
import projeto.kotlin.Api.DTOs.forms.novoTopicoForm
import projeto.kotlin.Api.DTOs.views.topicoView
import projeto.kotlin.Api.exceptions.notFoundException
import projeto.kotlin.Api.mapper.topicoFormMapper
import projeto.kotlin.Api.mapper.topicoViewMapper
import projeto.kotlin.Api.models.Topico
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class topicoService (
    private var Topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: topicoViewMapper,
    private val topicoFormMapper: topicoFormMapper,
    private val notFoundMessage: String = "ID não encontrado"
    ) {

    fun listarTopicos(): List<topicoView> { // Função que lista os topicos existentes
        return Topicos.stream().map { t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())

    }

    fun buscarPorID(ID: Long): topicoView {// Função que filtra os tópicos pelo ID
        val topico = Topicos.stream().filter({
            t -> t.id == ID
        }).findFirst().orElseThrow{notFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: novoTopicoForm): topicoView { // Cadastra um novo topico
        val topico = topicoFormMapper.map(form)

        topico.id = Topicos.size.toLong() +1 // Soma um numero ao index do array para não existir um id: 0

        Topicos = Topicos.plus(topico) // adiciona o topico a lista

        return  topicoViewMapper.map(topico)
    }

    fun atualizar(form: AttTopicoform): topicoView {
        val topico = Topicos.stream().filter({// filtra o topico que será atualizado pelo id
                t -> t.id == form.id
        }).findFirst().orElseThrow{notFoundException(notFoundMessage)}

        val topicoAtualizado = Topico( // remove o topico existente e adiciona o topico atualizado
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao

        )
        Topicos = Topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = Topicos.stream().filter({// filtra o topico que será atualizado pelo id
            t -> t.id == id
            }).findFirst().orElseThrow{notFoundException(notFoundMessage)}
        Topicos = Topicos.minus(topico) // Remove o topico da lista
    }


}