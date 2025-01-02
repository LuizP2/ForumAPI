package projeto.kotlin.Api.services

import org.springframework.stereotype.Service
import projeto.kotlin.Api.models.Curso
import java.util.*

@Service
class CursoService(var Cursos: List<Curso>) {

    init {
        val Curso = Curso( // Data hardcoded
            idcurso = 1,
            nome = "string",
            categoria = "lorem ipsum"
        )
        Cursos = Arrays.asList(Curso) // Identifica o curso referenciado dentro da lista
    }
    fun cursoPorID(id: Long): Curso{ // função para filtrar o curso pelo id
        return  Cursos.stream().filter({
            c -> c.idcurso == id
        }).findFirst().get()
    }
}
