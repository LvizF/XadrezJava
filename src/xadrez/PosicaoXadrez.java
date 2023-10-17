package xadrez;

import tabuleiro.Posicao;

import java.util.Arrays;

public class PosicaoXadrez extends Posicao {
    private int linha;
    private char coluna;

    public PosicaoXadrez(char coluna, int linha) throws ExcecaoXadrez {
        super();
        if (coluna < 'a' || linha < 1 || coluna > 'h' || linha > 8)
            throw new ExcecaoXadrez(String.format("A posição %c%d não existe.", coluna, linha));
        this.linha = linha;
        this.coluna = coluna;
    }

    protected Posicao paraPosicao(){
        return new Posicao(linha-1, this.coluna - 'a');
    }

     protected static PosicaoXadrez dePosicao(Posicao pos) throws ExcecaoXadrez{
        return new PosicaoXadrez((char)('a'+ pos.getColuna()), pos.getLinha()+1);
    }

    @Override
    public String toString(){
        return String.format("%c%d", this.coluna, this.linha);
    }
}
