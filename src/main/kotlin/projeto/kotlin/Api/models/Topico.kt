package projeto.kotlin.Api.models

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
data class Topico( // data class para o objeto topico
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne val curso: curso,
    @ManyToOne val autor: usuario,
    @Enumerated(value = EnumType.STRING) val status: StatusTopíco = StatusTopíco.NAO_RESPONDIDO,
    @OneToMany(mappedBy = "topico") val respostas: List<Res> = ArrayList()
)