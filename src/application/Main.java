package application;

import xadrez.PartidaXadrez;
import xadrez.Rei;

public class Main {
    public static void main(String[] args) throws Exception{
        PartidaXadrez partida = new PartidaXadrez();

        Interface.imprime(partida.getPecas());
    }
}
