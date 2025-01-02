package projeto.kotlin.Api.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico( // data class para o objeto topico
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne val curso: Curso,
    @ManyToOne val autor: Usuario,
    @Enumerated(value = EnumType.STRING) val status: StatusTopíco = StatusTopíco.NAO_RESPONDIDO,
    @OneToMany(mappedBy = "topico") val respostas: List<Res> = ArrayList()
)