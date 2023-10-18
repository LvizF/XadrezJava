package application;

import xadrez.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        PartidaXadrez partida = new PartidaXadrez();
        PosicaoXadrez orig;
        PosicaoXadrez dest;

        Scanner entrada = new Scanner(System.in);
        while (!partida.getXequeMate()) {
            Interface.limparTela();
            try {
                Interface.imprimePartida(partida);
                System.out.print("Casa de origem: ");
                orig = Interface.lerPosicao(entrada);

                boolean[][] movs_possiveis = partida.movimentosPossiveis(orig);

                Interface.limparTela();

                Interface.imprimePartida(partida, movs_possiveis);

                System.out.print("Casa de destino: ");
                dest = Interface.lerPosicao(entrada);

                partida.fazerMovimento(orig, dest);

                if (partida.hapromocao()){
                    System.out.printf("Escolha o tipo de peça a que quer promover o peão (D/B/C/T): ");
                    partida.substituiPromovido(entrada.nextLine());
                }

            }catch(Exception e){
                System.out.print(e.getMessage());
                entrada.nextLine();
            }
        }

        Interface.limparTela();
        Interface.imprimePartida(partida);

    }
}
