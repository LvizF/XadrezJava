package xadrez;

import tabuleiro.Tabuleiro;

public class Bispo extends PecaXadrez{
    public Bispo(PosicaoXadrez pos, String cor, Tabuleiro tabuleiro) {
        super(pos, cor, tabuleiro);
    }

    public String toString(){
        return "B";
    }
}
