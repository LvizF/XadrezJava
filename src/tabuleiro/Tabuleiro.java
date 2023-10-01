package tabuleiro;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas){
        this.linhas = linhas;
        this.colunas = colunas;
        this.pecas = new Peca[linhas][colunas];
    }

    public Peca getPeca(int linha, int coluna){
        return this.pecas[linha][coluna];
    }

    public Peca getPeca(Posicao pos){
        return this.pecas[pos.getLinha()][pos.getColuna()];
    }

    public boolean haPeca(Posicao pos){
        if (this.pecas[pos.getLinha()][pos.getColuna()] != null)
            return true;

        return false;
    }

    public boolean posicaoExiste(Posicao pos){
        if (pos.getLinha() < this.linhas && pos.getColuna() < this.colunas)
            return true;

        return false;
    }

    public void colocarPeca(Peca peca, Posicao pos) throws ExcecaoTabuleiro{
        if (pos.getColuna() >= this.colunas || pos.getLinha() >= this.linhas)
            throw new ExcecaoTabuleiro("Posição excede os limites do tabuleiro.");

        this.pecas[pos.getLinha()][pos.getColuna()] = peca;
    }

    public Peca removerPeca(Posicao pos) throws ExcecaoTabuleiro{
        if (pos.getColuna() >= this.colunas || pos.getLinha() >= this.linhas)
            throw new ExcecaoTabuleiro("Posição excede os limites do tabuleiro.");

        Peca p = this.pecas[pos.getLinha()][pos.getColuna()];
        this.pecas[pos.getLinha()][pos.getColuna()] = null;
        return p;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
}
