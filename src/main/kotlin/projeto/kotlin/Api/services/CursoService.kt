package projeto.kotlin.Api.services

import org.springframework.stereotype.Service
import projeto.kotlin.Api.models.curso
import java.util.*

@Service
class CursoService(var cursos: List<curso>) {

    init {
        val Curso = curso( // Data hardcoded
            idcurso = 1,
            nome = "string",
            categoria = "lorem ipsum"
        )
        cursos = Arrays.asList(Curso) // Identifica o curso referenciado dentro da lista
    }
    fun cursoPorID(id: Long): curso{ // função para filtrar o curso pelo id
        return  cursos.stream().filter({
            c -> c.idcurso == id
        }).findFirst().get()
    }
}
