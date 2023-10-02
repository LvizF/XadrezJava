package xadrez;
import tabuleiro.Tabuleiro;

public class Torre extends PecaXadrez{
    public Torre(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    public String toString(){
        return "T";
    }
}
