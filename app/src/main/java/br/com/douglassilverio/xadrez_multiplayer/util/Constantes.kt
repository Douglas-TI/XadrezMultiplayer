package br.com.douglassilverio.xadrez_multiplayer.util

enum class Constantes(var valor:Int, var descricao: String) {


    P1(0, "Jogador 1"),
    P2(1, "Jogador 2"),
    NADA_SELECIONADO(0, ""),
    TABULEIRO(0, "Tabuleiro"),
    POSICAO_VAZIA(0, "V"),
    TOTAL_POSICOES_TABULEIRO(64, ""),
    TOTAL_POSICOES_COLUNA(8, ""),
    TOTAL_POSICOES_LINHA(8, ""),
    TORRE_BRANCA(0,"tb"),
    TORRE_PRETA(0,"tp"),
    INIT_VAR_INT(0, ""),

    BRANCAS(0, "B"),
    PRETAS(0, "P"),
    PEAO(0, "P"),
    TORRE(0, "T"),
    CAVALO(0, "C"),
    BISPO(0, "B"),
    REI(0, "R"),
    RAINHA(0, "Q");

    override fun toString(): String {
        return this.descricao
    }

    fun valor(): Int{
        return this.valor
    }
}