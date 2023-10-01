package xadrez;

import tabuleiro.Posicao;

import java.util.Arrays;

public class PosicaoXadrez extends Posicao {
    private int linha;
    private char coluna;
    public static char[] colunas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public PosicaoXadrez(int linha, int coluna){
        super(linha, coluna);
    }

    public PosicaoXadrez(int linha, char coluna){
        super(linha, Arrays.asList(colunas).indexOf(coluna));
    }

    protected Posicao paraPosicao(){
        return new Posicao(linha, Arrays.asList(colunas).indexOf(coluna));
    }

     protected static PosicaoXadrez dePosicao(Posicao pos){
        return new PosicaoXadrez(pos.getLinha(), colunas[pos.getColuna()]);
    }
}
