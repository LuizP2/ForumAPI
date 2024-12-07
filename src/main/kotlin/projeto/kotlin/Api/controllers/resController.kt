package projeto.kotlin.Api.controllers

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import projeto.kotlin.Api.DTOs.forms.attResForm
import projeto.kotlin.Api.DTOs.forms.resForm
import projeto.kotlin.Api.DTOs.views.resView
import projeto.kotlin.Api.models.Res
import projeto.kotlin.Api.services.resService

@RestController
@RequestMapping("topicos/{id}/respostas")
class resController (private val service: resService){
    @GetMapping
    fun listarRes(@PathVariable id: Long): List<Res> {
        return service.listar(id)
    }
    @GetMapping("/{ID}")
    fun buscarPorID(@PathVariable ID: Long): resView{
        return service.buscarPorID(ID)
    }
    @PostMapping
    fun cadastrarRes(@PathVariable id: Long, @RequestBody @Valid dto: resForm,
                     uriBuilder: UriComponentsBuilder): ResponseEntity<resView>{
        val resView = service.cadastrar(dto, id)
        val uri = uriBuilder.path("/respostas/${resView.id}").build().toUri() //Transforma o caminho em Uri
        return ResponseEntity.created(uri).body(resView)
    }
    @PutMapping
    fun atualizarRes(@RequestBody @Valid form: attResForm): ResponseEntity<resView>{
        val resView = service.atualizar(form)
        return ResponseEntity.ok(resView)
    }
    @DeleteMapping("/{ID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }
}