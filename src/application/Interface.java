package application;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.ExcecaoXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private static char[] colunas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public static PosicaoXadrez lerPosicao(Scanner teclado) throws InputMismatchException{
        try {
            String pos = teclado.nextLine();
            return new PosicaoXadrez(pos.charAt(0), Integer.valueOf(pos.substring(1)));
        }catch (Exception e) {
            throw new InputMismatchException("Posição inválida.");
        }
    }

    public static void imprime(PecaXadrez pecas[][]){
        int n = 0;

        for (int i = pecas.length-1; i >= 0; i--){
            for (int j = 0; j < pecas.length; j++) {
                System.out.printf(" %s ",
                        (pecas[i][j] == null) ? ANSI_WHITE + "*"
                                : String.format("%s%s",
                                (pecas[i][j] == null || pecas[i][j].getCor() == Cor.BRANCO) ? ANSI_YELLOW : ANSI_RED,
                                pecas[i][j]));
            }

            System.out.printf("%s %d\n", ANSI_RESET, i+1);
            n ^= 1;
        }
        for (int i = 0; i < pecas.length; i++)
            System.out.printf(" %c ", colunas[i]);
        System.out.println();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
