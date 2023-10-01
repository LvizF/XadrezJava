package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        this.tabuleiro = new Tabuleiro(8, 8);
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] matriz = new PecaXadrez[this.tabuleiro.getLinhas()][this.tabuleiro.getColunas()];
        for (int i = 0; i < this.tabuleiro.getLinhas(); i++){
            for (int j = 0; j < this.tabuleiro.getColunas(); j++){
                Posicao p = new Posicao(i, j);
                if (this.tabuleiro.haPeca(p)){
                    matriz[i][j] = (PecaXadrez) this.tabuleiro.getPeca(p);
                }
            }
        }
        return matriz;
    }
}
