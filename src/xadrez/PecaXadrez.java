package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    private Cor cor;
    private int contagemMovimentos;

    public PecaXadrez(PosicaoXadrez pos, String cor, Tabuleiro tabuleiro){
        super(pos, tabuleiro);
        this.cor = Cor.valueOf(cor);
        this.contagemMovimentos = 0;
    }

    public PosicaoXadrez getPosicaoXadrez(){
        return PosicaoXadrez.dePosicao(this.posicao);
    }

    /*protected boolean haPecaInimiga(Posicao pos){}


    public void aumentarContagemMovimentos(){
        this.contagemMovimentos++;
    }

    public void reduzirContagemMovimentos(){
        this.contagemMovimentos--;
    }

    public Cor getCor() {
        return cor;
    }

    public int getContagemMovimentos() {
        return contagemMovimentos;
    }*/
}