package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoPosicao
import br.com.douglassilverio.xadrez_multiplayer.model.Jogador
import br.com.douglassilverio.xadrez_multiplayer.model.PosicoesPecasTabuleiro

class TabuleiroPresenter(private var viewTabuleiroActivity: ITabuleiroActivity) : ITabuleiroPresenter{

    var posicoesPecasTabuleiro = PosicoesPecasTabuleiro(viewTabuleiroActivity)
    var jogador = Jogador()

    private var estadoPosicao: EstadoPosicao = EstadoPosicao()

    override fun recebeAcao(posSelecionada: View){
        tratarSelecaoPosicao(posSelecionada)
    }

    private fun tratarSelecaoPosicao(posSelecionada: View) {
        if(mudarPecaSelecionada(posSelecionada))
            return

        if(selecionarPeca(posSelecionada))
            return

        if(desselecionarPeca(posSelecionada))
            return
    }

    private fun selecionarPeca(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) != Color.RED ) {//&& jogador.cor == getCorPecaSelecionada(posSelecionada)
            estadoPosicao.corDestaqueUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoPosicao.idPosSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)

            return true
        }
        return false
    }

    private fun desselecionarPeca(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) == Color.RED){
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, estadoPosicao.corDestaqueUltimaPos)
            estadoPosicao.idPosSelecionada = 0
            return true
        }
        return false
    }

    private fun mudarPecaSelecionada(posSelecionada: View): Boolean{
        if(posSelecionada.id != estadoPosicao.idPosSelecionada && estadoPosicao.idPosSelecionada != 0) {
            val antigaPosDestacada: View = viewTabuleiroActivity.getViewById(estadoPosicao.idPosSelecionada)
            viewTabuleiroActivity.mudarDestaquePos(antigaPosDestacada, estadoPosicao.corDestaqueUltimaPos)

            estadoPosicao.corDestaqueUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoPosicao.idPosSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)
            return true
        }
        return false
    }

    fun getCorPecaSelecionada(posSelecionada: View){

    }

    private fun getColorBackgroundPos(posSelecionada: View) : Int {
        return (posSelecionada.background as ColorDrawable).color
    }
}