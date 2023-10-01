package xadrez;

import tabuleiro.Tabuleiro;

public class Dama extends PecaXadrez{
    public Dama(PosicaoXadrez pos, String cor, Tabuleiro tabuleiro) {
        super(pos, cor, tabuleiro);
    }

    public String toString(){
        return "D";
    }
}
