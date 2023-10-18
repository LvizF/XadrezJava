package tabuleiro;


public abstract class Peca {
    protected Posicao posicao;
    protected Posicao posicaoAntiga;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro){
        this.posicao = null;
        this.posicaoAntiga = null;
        this.tabuleiro = tabuleiro;
    }

    public abstract boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro;
    public boolean movimentoPossivel(Posicao pos) throws ExcecaoTabuleiro {
        return this.movimentosPossiveis()[pos.getLinha()][pos.getColuna()];
    }

    //Tornar em método abstrato depois.
    public boolean haAlgumMovimentoPossivel() throws ExcecaoTabuleiro {
        boolean[][] matrizTemp = this.movimentosPossiveis();
        for (int i = 0; i < matrizTemp.length; i++)
            for (int j = 0; j < matrizTemp.length; j++)
                if (matrizTemp[i][j])
                    return true;
        return false;
    }
    //public abstract void mudaPosicao(Posicao pos);

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setPosicao(Posicao pos){
        this.posicaoAntiga = this.posicao;
        this.posicao = pos;
    }

    public Posicao getPosicao(){
        return posicao;
    }
}
