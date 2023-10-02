package tabuleiro;

import xadrez.ExcecaoXadrez;

public class Posicao {
    private int coluna;
    private int linha;
    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Posicao() {
    }

    public void setValores(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }
}
