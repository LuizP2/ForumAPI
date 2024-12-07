package projeto.kotlin.Api.mapper

interface Mapper<T, U> { // GENERICS
    fun map(t: T): U // Converte um topico em um topicoView
}
