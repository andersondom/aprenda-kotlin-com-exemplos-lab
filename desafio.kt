// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
data class Usuario(val nome: String, val id: Long)

data class ConteudoEducacional(val nome: String, val stack: String, val duracao: Int = 60)
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    infix fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios)
            inscritos.add(usuario)
    }

    fun mostrarConteudos() {
        for (conteudo in conteudos)
            println("${conteudo.nome} - ${conteudo.stack}")
    }

    fun mostrarInscritos() {
        for (inscrito in inscritos)
            println(inscrito.nome)
    }
}

fun main() {
    // Criando os usuários
    val anderson = Usuario("Anderson", 1L)
    val carlos = Usuario("Carlos", 2L)
    val luara = Usuario("Luana", 3L)
    val sara = Usuario("Sara", 4L)

    // Criando a lista de conteúdos da formação
    val listaConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Introdução à Programação e Informática","IPI"),
        ConteudoEducacional("Conceitos Básicas de Kotlin","CBK"),
        ConteudoEducacional("Programação Orientada a Objetos","POO"),
        ConteudoEducacional("Sistemas de Informação","SI"))

    // Criando a formação para Kotlin
    val kotlinExperience = Formacao("Aprendendo Kotlin", listaConteudosKotlin, Nivel.INTERMEDIARIO)

    // Verificando se a variável de formação não é nula, caso não seja, matriculando alunos
    kotlinExperience?.let{
        kotlinExperience.matricular(carlos, anderson, luara, sara)
    }

    // Imprimindo na tela
    println("Formação: ${kotlinExperience.nome}")
    println("\n")
    println("Conteúdos:")
    kotlinExperience.mostrarConteudos()
    println("\n")
    println("Inscritos:")
    kotlinExperience.mostrarInscritos()
    println("____________________________________________________________")
}
