package tabuleiro;

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro){
        this.posicao = null;
        this.tabuleiro = tabuleiro;
    }

    /*public abstract boolean[][] movimentosPossiveis();
    public abstract boolean movimentoPossivel(Posicao pos);
    public abstract boolean haAlgumMovimentoPossivel();
    public abstract void mudaPosicao(Posicao pos);*/

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setPosicao(Posicao pos){
        this.posicao = pos;
    }
}
