package application;

import tabuleiro.Posicao;
import xadrez.ExcecaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.Rei;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        PartidaXadrez partida = new PartidaXadrez();

        Interface.imprime(partida.getPecas());
        Scanner entrada = new Scanner(System.in);
        while (true) {
            try {
                System.out.printf("Insira a posição de origem: ");
                PosicaoXadrez orig = Interface.lerPosicao(entrada);

                System.out.printf("Insira a posição de destino: ");
                PosicaoXadrez dest = Interface.lerPosicao(entrada);

                partida.fazerMovimento(orig, dest);
                Interface.imprime(partida.getPecas());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
