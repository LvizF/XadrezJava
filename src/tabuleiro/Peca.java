package tabuleiro;

import javafx.scene.control.Tab;

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public abstract boolean[][] movimentosPossiveis();
    public abstract boolean movimentoPossivel(Posicao pos);
    public abstract boolean haAlgumMovimentoPossivel();
    public abstract void mudaPosicao(Posicao pos);

}
