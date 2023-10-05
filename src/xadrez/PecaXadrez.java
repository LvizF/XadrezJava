package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    private Cor cor;
    private int contagemMovimentos;

    public PecaXadrez(Cor cor, Tabuleiro tabuleiro){
        super(tabuleiro);
        this.cor = cor;
        this.contagemMovimentos = 0;
    }

    public PosicaoXadrez getPosicaoXadrez() throws ExcecaoXadrez{
        return PosicaoXadrez.dePosicao(this.posicao);
    }

    protected boolean haPecaAdversaria(Posicao pos) throws ExcecaoTabuleiro {
        return ((PecaXadrez) this.getTabuleiro().getPeca(pos)).getCor() != this.getCor();
    }

    /*protected boolean haPecaInimiga(Posicao pos){}


    public void aumentarContagemMovimentos(){
        this.contagemMovimentos++;
    }

    public void reduzirContagemMovimentos(){
        this.contagemMovimentos--;
    }

    */
    public Cor getCor() {
        return cor;
    }
    /*

    public int getContagemMovimentos() {
        return contagemMovimentos;
    }*/
}
