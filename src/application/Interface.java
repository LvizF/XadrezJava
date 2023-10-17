package application;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void imprimePartida(PartidaXadrez partida) throws ExcecaoTabuleiro {
        imprimeTopo(partida.getJogadorAtual(), partida.getTurno(), partida.getXeque(), partida.getXequeMate());

        imprimirPecasCapturadas(partida.getPecasCapturadas());
        imprime(partida.getPecas());
    }

    public static void imprimePartida(PartidaXadrez partida, boolean[][] movimentos) throws ExcecaoTabuleiro {
        imprimeTopo(partida.getJogadorAtual(), partida.getTurno(), partida.getXeque(), partida.getXequeMate());
        imprimirPecasCapturadas(partida.getPecasCapturadas());
        imprime(partida.getPecas(), movimentos);
    }

    private static void imprimeTopo(Cor jogadorAtual, int turno, boolean xeque, boolean xeque_mate){
        if (!xeque_mate) {
            System.out.printf("%s%sTURNO ATUAL: %s.%s\n", ANSI_WHITE_BACKGROUND, ANSI_BLACK,
                    (jogadorAtual == Cor.BRANCO) ? "BRANCAS" : "PRETAS",
                    ANSI_RESET);
            if (xeque)
                System.out.printf("%s%sEM XEQUE.%s\n", ANSI_WHITE_BACKGROUND, ANSI_RED, ANSI_RESET);
        }else
            System.out.printf("%sXEQUE-MATE! VITÓRIA DAS %s.\n%s", ANSI_RED, (jogadorAtual == Cor.PRETO) ?
                    "PRETAS" : "BRANCAS", ANSI_RESET);

        System.out.printf("TURNO %d.\n", turno);


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

    public static void imprimirPecasCapturadas(ArrayList<PecaXadrez> pecas){
        ArrayList brancas = new ArrayList<PecaXadrez>();
        ArrayList pretas = new ArrayList<PecaXadrez>();

        for (PecaXadrez p : pecas)
            if (p.getCor() == Cor.BRANCO)
                brancas.add(p);
            else
                pretas.add(p);

            System.out.printf("%s%sPEÇAS CAPTURADAS.%s\n", ANSI_BLACK, ANSI_WHITE_BACKGROUND, ANSI_RESET);

        System.out.printf("BRANCAS: %s%s.\n%sPRETAS: %s%s%s.\n", ANSI_YELLOW, Arrays.toString(brancas.toArray()),
                                                ANSI_WHITE, ANSI_RED, Arrays.toString(pretas.toArray()),
                                                ANSI_RESET);

        System.out.print("\n");
    }
}
