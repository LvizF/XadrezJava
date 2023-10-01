package xadrez;

import tabuleiro.Tabuleiro;

public class Peao extends PecaXadrez{
    public Peao(PosicaoXadrez pos, String cor, Tabuleiro tabuleiro) {
        super(pos, cor, tabuleiro);
    }

    public String toString(){
        return "P";
    }
}
