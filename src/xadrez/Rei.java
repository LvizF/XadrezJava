package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez{
    public Rei(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        boolean[][] movs = new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];

        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();

        Posicao pos = new Posicao();

        //Uma fileira acima.
        pos.setValores(linha+1, coluna-1);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha+1, coluna);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha+1, coluna+1);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        //Mesma fileira.
        pos.setValores(linha, coluna-1);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha, coluna);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha, coluna+1);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        //Uma fileira abaixo.
        pos.setValores(linha-1, coluna-1);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha-1, coluna);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha-1, coluna+1);
        if (this.getTabuleiro().posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;


        return movs;
    }

    private boolean movimentoPossivelParaoRei(Posicao pos) throws ExcecaoTabuleiro {
        PecaXadrez p = (PecaXadrez) this.getTabuleiro().getPeca(pos);

        return p == null || p.getCor() != this.getCor();
    }
}
