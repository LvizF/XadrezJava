package xadrez;

import tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez{
    public Rei(PosicaoXadrez pos, String cor, Tabuleiro tabuleiro) {
        super(pos, cor, tabuleiro);
    }

    public String toString(){
        return "R";
    }
}
