package application;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";

    private static char[] colunas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public static PosicaoXadrez lerPosicao(Scanner teclado) throws InputMismatchException{
        try {
            String pos = teclado.nextLine();
            return new PosicaoXadrez(pos.charAt(0), Integer.valueOf(pos.substring(1)));
        }catch (Exception e) {
            throw new InputMismatchException("Posição inválida.");
        }
    }

    public static void imprimePartida(PartidaXadrez partida){
        System.out.printf("%s%sTURNO ATUAL: %s.%s\n", ANSI_WHITE_BACKGROUND, ANSI_BLACK,
                (partida.getJogadorAtual() == Cor.BRANCO) ? "BRANCAS" : "PRETAS",
                ANSI_RESET);
        System.out.printf("TURNO %d.\n", partida.getTurno());
    }

    public static void imprime(PecaXadrez pecas[][]){

        for (int i = pecas.length-1; i >= 0; i--){
            for (int j = 0; j < pecas.length; j++)
                imprime_peca(pecas[i][j]);
            System.out.printf("%s %d\n", ANSI_RESET, i+1);
        }

        for (int i = 0; i < pecas.length; i++)
            System.out.printf(" %c ", colunas[i]);
        System.out.println();
    }

    public static void imprime(PecaXadrez[][] pecas, boolean[][] movs){
        for (int i = pecas.length-1; i >= 0; i--){
            for (int j = 0; j < pecas.length; j++)
                imprime_peca(pecas[i][j], movs[i][j]);
            System.out.printf("%s %d\n", ANSI_RESET, i+1);
        }

        for (int i = 0; i < pecas.length; i++)
            System.out.printf(" %c ", colunas[i]);
        System.out.println();
    }

    private static void imprime_peca(PecaXadrez peca){
        System.out.printf(" %s%s ",
                (peca == null) ? ANSI_WHITE + "*"
                        : String.format("%s%s",
                        (peca == null || peca.getCor() == Cor.BRANCO) ? ANSI_YELLOW : ANSI_RED,
                        peca), ANSI_BLACK_BACKGROUND);
    }

    private static void imprime_peca(PecaXadrez peca, boolean mov_possivel){
        if (mov_possivel)
            System.out.printf("%s", ANSI_BLUE_BACKGROUND);

        imprime_peca(peca);
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
