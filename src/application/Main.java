package application;

import tabuleiro.Posicao;
import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.Rei;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        PartidaXadrez partida = new PartidaXadrez();
        PosicaoXadrez orig = null;
        PosicaoXadrez dest = null;


        Scanner entrada = new Scanner(System.in);
        while (true) {
            Interface.limparTela();
            try {
                Interface.imprimePartida(partida);
                Interface.imprime(partida.getPecas());
                System.out.print("Casa de origem: ");
                orig = Interface.lerPosicao(entrada);

                boolean[][] movs_possiveis = partida.movimentosPossiveis(orig);

                Interface.limparTela();

                Interface.imprimePartida(partida);
                Interface.imprime(partida.getPecas(), movs_possiveis);

                System.out.print("Casa de destino: ");
                dest = Interface.lerPosicao(entrada);

                partida.fazerMovimento(orig, dest);
            }catch(ExcecaoXadrez e){
                System.out.print(e.getMessage());
                entrada.nextLine();
            }catch(InputMismatchException e){
                System.out.print(e.getMessage());
                entrada.nextLine();
            }
        }

    }
}
