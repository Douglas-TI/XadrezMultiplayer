package br.com.douglassilverio.xadrez_multiplayer.model

import android.util.Log
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.Pecas
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.Torre
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class PosicoesTabuleiro {

    var tb = Torre(Constantes.P1.toString(),0, 0)

    var tabuleiro: Array<Array<Any>> = arrayOf(
        arrayOf(tb, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0, 0))

    fun printPosicoesTabuleiro(){
        for ((i, linha) in tabuleiro.withIndex())
            Log.i(Constantes.TABULEIRO.toString(), tabuleiro[i].contentToString())
    }
}