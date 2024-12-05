package projeto.kotlin.Api.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import projeto.kotlin.Api.DTOs.novoTopicoForm
import projeto.kotlin.Api.DTOs.topicoView
import projeto.kotlin.Api.models.topico
import projeto.kotlin.Api.services.topicoService

@RestController
@RequestMapping("/topicos")
class controllerTopico(private val service: topicoService) { // recebe o localhost:8080/topicos

    @GetMapping // Get
    fun listarTopicos( ): List<topicoView> { // chama a função que irá listar os topicos para o cliente
        return service.listarTopicos()
    }

    @GetMapping("/{id}") // Get
    fun IDlist(@PathVariable id: Long): topicoView { // Filtra o topico pelo ID inserido
        return service.IDlist(id)
    }
    @PostMapping // Post
    fun cadastrarPosts(@RequestBody topico: novoTopicoForm) { // chama a função para cadastrar o novo topico
        service.cadastrar(topico)
    }
}