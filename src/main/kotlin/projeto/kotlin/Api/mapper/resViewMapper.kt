package projeto.kotlin.Api.mapper

import org.springframework.stereotype.Component
import projeto.kotlin.Api.DTOs.views.resView
import projeto.kotlin.Api.models.Res

@Component
class resViewMapper (

): Mapper<Res, resView>{
    override fun map(t: Res): resView {
        return resView(
            id = t.id,
            Usuario = t.usuario,
            Topico = t.topico,
            mensagem = t.mensagem,
            solucao = t.solucao
        )

    }
}