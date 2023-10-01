package xadrez;

import tabuleiro.ExcecaoTabuleiro;

public class ExcecaoXadrez extends Exception {
    public ExcecaoXadrez(String msg){
        super(msg);
    }
}
