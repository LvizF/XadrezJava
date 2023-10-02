package tabuleiro;

import xadrez.ExcecaoXadrez;
import xadrez.PosicaoXadrez;

public class Tabuleiro {
    private final int linhas;
    private final int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) throws ExcecaoTabuleiro{
        if (linhas < 1 || colunas < 1)
            throw new ExcecaoTabuleiro("O números de linhas e de linhas devem ser maiores que zero.");

        this.linhas = linhas;
        this.colunas = colunas;
        this.pecas = new Peca[linhas][colunas];
    }

    public Peca getPeca(int linha, int coluna) throws ExcecaoTabuleiro{
        if (!this.posicaoExiste(linha, coluna))
            throw new ExcecaoTabuleiro("A posição indicada não existe no tabuleiro.");
        return this.pecas[linha][coluna];
    }

    public Peca getPeca(Posicao pos) throws ExcecaoTabuleiro{
        if (!this.posicaoExiste(pos))
            throw new ExcecaoTabuleiro("A posição indicada não existe no tabuleiro.");

        return this.getPeca(pos.getLinha(), pos.getColuna());
    }

    public boolean haPeca(Posicao pos) throws ExcecaoTabuleiro{
        if (!this.posicaoExiste(pos))
            throw new ExcecaoTabuleiro("A posição indicada não existe no tabuleiro.");

        return this.getPeca(pos) != null;
    }

    public boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && coluna >= 0 && linha < this.getLinhas() && coluna < this.getColunas();
    }
    public boolean posicaoExiste(Posicao pos){
        return pos.getLinha() >= 0 && pos.getColuna() >= 0 && pos.getLinha() < this.linhas && pos.getColuna() < this.colunas;
    }

    public void colocarPeca(Peca peca, Posicao pos) throws ExcecaoTabuleiro{
        if (this.haPeca(pos))
            throw new ExcecaoTabuleiro("Há já uma peça na posição dada.");

        this.pecas[pos.getLinha()][pos.getColuna()] = peca;
        peca.setPosicao(pos);
    }

    public Peca removerPeca(Posicao pos) throws ExcecaoTabuleiro{
        if (!this.haPeca(pos))
            throw new ExcecaoTabuleiro("Não há peça na posição indicada.");

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
