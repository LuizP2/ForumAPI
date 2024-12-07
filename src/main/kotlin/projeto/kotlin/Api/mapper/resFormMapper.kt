package projeto.kotlin.Api.mapper

import org.springframework.stereotype.Component
import projeto.kotlin.Api.DTOs.forms.resForm
import projeto.kotlin.Api.models.Res
import projeto.kotlin.Api.services.UserService
import projeto.kotlin.Api.services.topicoService

@Component
class resFormMapper(
    private val UserService: UserService,
    private val topicoService: topicoService

): Mapper<resForm, Res> {
    override fun map(t: resForm): Res {
        return Res(
            mensagem = t.mensagem,
            usuario = UserService.userPorID(t.iduser),
            id = t.id,
            topico = topicoService.buscarPorID(t.id),
            solucao = t.solucao
        )
    }
}