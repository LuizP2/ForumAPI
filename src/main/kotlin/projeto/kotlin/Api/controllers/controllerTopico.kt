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
import projeto.kotlin.Api.DTOs.forms.AttTopicoform
import projeto.kotlin.Api.DTOs.forms.novoTopicoForm
import projeto.kotlin.Api.DTOs.views.topicoView
import projeto.kotlin.Api.services.topicoService

@RestController
@RequestMapping("/topicos")// recebe o localhost:8080/topicos
class controllerTopico(private val service: topicoService/*indica de onde vem os serviços*/) {

    @GetMapping // Get
    fun listarTopicos( ): List<topicoView> { // chama a função que irá listar os topicos para o cliente
        return service.listarTopicos()
    }

    @GetMapping("/{id}") // Get
    fun IDlist(@PathVariable id: Long): topicoView { // Filtra o topico pelo ID inserido
        return service.buscarPorID(id)
    }
    @PostMapping // Post
    fun cadastrarPosts(@RequestBody @Valid topico: novoTopicoForm, /* chama a função para cadastrar o novo topico*/
                       uriBuilder: UriComponentsBuilder): ResponseEntity<topicoView> {// Busca a Uri antes dos caminhos
        val topicoView = service.cadastrar(topico)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri() //Transforma o caminho em Uri
        return ResponseEntity.created(uri).body(topicoView) // retorna o corpo do objeto adicionado
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AttTopicoform): ResponseEntity<topicoView> { // função disparada ao fazer uma requisição PUT
        val topicoView = service.atualizar(form) // Chama o método .atualizar da service
        return ResponseEntity.ok(topicoView) // retorna o corpo da atualização
    }
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // retorna codigo http 204 (Boas Praticas)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)

    }

}