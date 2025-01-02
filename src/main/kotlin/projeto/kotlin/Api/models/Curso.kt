package projeto.kotlin.Api.models



import javax.persistence.*


@Entity

data class Curso ( // Data class do objeto curso
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idcurso: Long? = null,
    val nome: String,
    val categoria: String
)
