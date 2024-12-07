package projeto.kotlin.Api.services

import org.springframework.stereotype.Service
import projeto.kotlin.Api.DTOs.forms.attResForm
import projeto.kotlin.Api.DTOs.forms.resForm
import projeto.kotlin.Api.DTOs.views.resView
import projeto.kotlin.Api.exceptions.notFoundException
import projeto.kotlin.Api.mapper.resFormMapper
import projeto.kotlin.Api.mapper.resViewMapper
import projeto.kotlin.Api.models.Res
import java.util.stream.Collectors

@Service
class resService(
    private var Res: List<Res>,
    private var resFormMapper: resFormMapper,
    private var resViewMapper: resViewMapper,
    private var topicoService: topicoService,
    private val notFoundMessage: String = "ID não encontrado"
) {
    fun listar(idTopico: Long): List<Res> {
        return Res.stream().filter { r ->
            r.topico.id == idTopico
        }.collect(Collectors.toList())
    }
    fun buscarPorID(ID: Long): resView {// Função que filtra os tópicos pelo ID
        val resultado = Res.stream().filter({
                t -> t.id == ID
        }).findFirst().orElseThrow{ notFoundException(notFoundMessage)}

        return resView( // retorna o topico filtrado
            id = resultado.id,
            mensagem = resultado.mensagem,
            Usuario = resultado.usuario,
            Topico = resultado.topico,
            solucao = resultado.solucao
        )
    }

    fun cadastrar(form: resForm, id: Long): resView {
        val resposta = resFormMapper.map(form)
        resposta.id = Res.size.toLong() + 1
        resposta.topico = topicoService.buscarPorID(id)
        Res = Res.plus(resposta)

        return resViewMapper.map(resposta)
    }

    fun atualizar(form: attResForm): resView{
        val resultado = Res.stream().filter({// filtra o topico que será atualizado pelo id
                t -> t.id == form.id
        }).findFirst().orElseThrow{ notFoundException(notFoundMessage)}
        val resultadoAtualizado = Res(
            id = resultado.id,
            mensagem = resultado.mensagem,
            usuario = resultado.usuario,
            topico = resultado.topico,
            solucao = resultado.solucao
        )
        Res = Res.minus(resultado).plus(resultadoAtualizado)

        return resViewMapper.map(resultadoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = Res.stream().filter({// filtra o topico que será atualizado pelo id
                t -> t.id == id
        }).findFirst().orElseThrow{ notFoundException(notFoundMessage)}
        Res = Res.minus(topico) // Remove o topico da lista
    }
}