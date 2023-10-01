package xadrez;
import tabuleiro.Tabuleiro;

public class Cavalo extends PecaXadrez{
    public Cavalo(PosicaoXadrez pos, String cor, Tabuleiro tabuleiro) {
        super(pos, cor, tabuleiro);
    }

    public String toString(){
        return "C";
    }
}
