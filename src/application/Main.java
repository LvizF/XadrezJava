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
                Interface.imprime(partida.getPecas());
                System.out.print("Casa de origem: ");
                orig = Interface.lerPosicao(entrada);

                System.out.print("Casa de destino: ");
                dest = Interface.lerPosicao(entrada);

                partida.fazerMovimento(orig, dest);
            }catch(ExcecaoXadrez e){
                System.out.print(e.getMessage());
            }catch(InputMismatchException e){
                System.out.print(e.getMessage());
            }finally {
                System.out.printf("\n(Pressione enter) ");
                entrada.nextLine();
            }
        }

    }
}
