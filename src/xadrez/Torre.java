package xadrez;
import tabuleiro.Tabuleiro;

public class Torre extends PecaXadrez{
    public Torre(PosicaoXadrez pos, String cor, Tabuleiro tabuleiro) {
        super(pos, cor, tabuleiro);
    }

    public String toString(){
        return "T";
    }
}
