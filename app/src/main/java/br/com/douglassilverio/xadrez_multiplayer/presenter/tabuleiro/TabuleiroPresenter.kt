package br.com.douglassilverio.xadrez_multiplayer.presenter.tabuleiro

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import br.com.douglassilverio.xadrez_multiplayer.activity.tabuleiro.ITabuleiroActivity
import br.com.douglassilverio.xadrez_multiplayer.model.EstadoBotoesDto
import br.com.douglassilverio.xadrez_multiplayer.model.JogadorDto

class TabuleiroPresenter(private var viewTabuleiroActivity: ITabuleiroActivity) : ITabuleiroPresenter{

    private var estadoBotoesDto = EstadoBotoesDto()
    var configuraTabuleiro = ConfiguraTabuleiro(this)
    private var gerenciaAcoesTabuleiro:GerenciaAcoesTabuleiro
    var jogador = JogadorDto()

    init {
        val tabuleiroArray2D = configuraTabuleiro.getTabuleiroArray2D()
        gerenciaAcoesTabuleiro = GerenciaAcoesTabuleiro(tabuleiroArray2D, estadoBotoesDto, this)
    }



    override fun recebeAcao(posSelecionada: View){
        tratarDestaqueVisualPosicaoSelecionada(posSelecionada)
        gerenciaAcoesTabuleiro.tratarMovimento(posSelecionada)
        configuraTabuleiro.printPosicoesTabuleiro()
    }


    private fun tratarDestaqueVisualPosicaoSelecionada(posSelecionada: View) {
        if(mudarDestaqueAtualParaNovaPecaSelecionada(posSelecionada))
            return

        if(destacarPecaSelecionada(posSelecionada))
            return

        if(removerDestaqueifPecaSelecionadaJaDestacada(posSelecionada))
            return

        //if jogada realizada foi válida remover destaque
    }

    private fun destacarPecaSelecionada(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) != Color.RED ) {//&& jogador.cor == getCorPecaSelecionada(posSelecionada)
            estadoBotoesDto.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoBotoesDto.idPosicaoSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)

            return true
        }
        return false
    }

    private fun removerDestaqueifPecaSelecionadaJaDestacada(posSelecionada: View): Boolean{
        if(getColorBackgroundPos(posSelecionada) == Color.RED){
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, estadoBotoesDto.corTileUltimaPos)
            estadoBotoesDto.idPosicaoSelecionada = 0
            return true
        }
        return false
    }

    private fun mudarDestaqueAtualParaNovaPecaSelecionada(posSelecionada: View): Boolean{
        if(posSelecionada.id != estadoBotoesDto.idPosicaoSelecionada && estadoBotoesDto.idPosicaoSelecionada != 0) {
            val antigaPosDestacada: View = viewTabuleiroActivity.getViewById(estadoBotoesDto.idPosicaoSelecionada)
            viewTabuleiroActivity.mudarDestaquePos(antigaPosDestacada, estadoBotoesDto.corTileUltimaPos)

            estadoBotoesDto.corTileUltimaPos = getColorBackgroundPos(posSelecionada)
            estadoBotoesDto.idPosicaoSelecionada = posSelecionada.id
            viewTabuleiroActivity.mudarDestaquePos(posSelecionada, Color.RED)
            return true
        }
        return false
    }

    private fun getColorBackgroundPos(posSelecionada: View) : Int {
        return (posSelecionada.background as ColorDrawable).color
    }

    override fun getViewById(idView:Int):View{
        return viewTabuleiroActivity.getViewById(idView)
    }
}