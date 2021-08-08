package br.com.douglassilverio.xadrez_multiplayer.model

import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.model.pecas.IPecas
import br.com.douglassilverio.xadrez_multiplayer.util.Constantes

class Posicao(private var peca:IPecas? = null, private var viewPosicao: View? = null, private var linha:Int? = null, private var coluna:Int? = null){

    override fun toString(): String {
        var corPeca = peca?.getCorPeca() ?: Constantes.POSICAO_VAZIA.text()
        var tipoPeca = peca?.getTipoPeca() ?: Constantes.POSICAO_VAZIA.text()
        var corTipoPeca = if(corPeca != Constantes.POSICAO_VAZIA.text() &&
            tipoPeca != Constantes.POSICAO_VAZIA.text()) tipoPeca + corPeca
            else "  "

        return "$coluna$linha$corTipoPeca"
    }

    fun novoParametro(viewPosicao: View?, linha:Int?, coluna:Int?, peca:IPecas? = null){
        this.peca = peca
        this.linha = linha
        this.coluna = coluna
    }
}




