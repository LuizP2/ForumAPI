package projeto.kotlin.Api.services

import org.springframework.stereotype.Service
import projeto.kotlin.Api.models.Usuario
import java.util.*

@Service
class UserService(var usuário: List<Usuario>) {

    init {
        val usuario = Usuario( // data hardcoded
            iduser = 1,
            nome = "Luiz",
            email = "Luiz@.com"
        )
        usuário = Arrays.asList(usuario) // identifica o usuário dentro da lista
    }
    fun userPorID(id: Long): Usuario { // identifica o usuário pelo id referenciado
        return  usuário.stream().filter({
                c -> c.iduser == id
        }).findFirst().get()
    }

}
