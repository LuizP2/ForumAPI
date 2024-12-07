package projeto.kotlin.Api.mapper

import org.springframework.stereotype.Component
import projeto.kotlin.Api.DTOs.views.topicoView
import projeto.kotlin.Api.models.Topico

@Component
class topicoViewMapper: Mapper<Topico, topicoView> {
    override fun map(t: Topico): topicoView { //recebe o topico normal e retorna o topicoView
       return topicoView(
        id = t.id,
        titulo = t.titulo,
        mensagem = t.mensagem,
        dataCriacao = t.dataCriacao,
        status = t.status
        )
    }
}