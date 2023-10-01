package application;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Interface {
    private static  char[] colunas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public static void imprime(PecaXadrez pecas[][]){
        for (int i = 0; i < pecas.length; i++){
            for (int j = 0; j < pecas.length; j++)
                System.out.printf(" %s ",
                        (pecas[i][j] == null) ? "*" : pecas[i][j]);
            System.out.printf("%d\n", i+1);
        }
        for (int i = 0; i < pecas.length; i++)
            System.out.printf(" %c ", colunas[i]);
        System.out.println();
    }
}
