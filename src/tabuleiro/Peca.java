package tabuleiro;

import javafx.scene.control.Tab;

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Posicao pos, Tabuleiro tabuleiro){
        this.posicao = pos;
        this.tabuleiro = tabuleiro;
    }

    /*public abstract boolean[][] movimentosPossiveis();
    public abstract boolean movimentoPossivel(Posicao pos);
    public abstract boolean haAlgumMovimentoPossivel();
    public abstract void mudaPosicao(Posicao pos);*/

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
