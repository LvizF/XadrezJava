package xadrez;

import tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez{
    public Rei(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    public String toString(){
        return "R";
    }
}
