package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Rei extends PecaXadrez{
    private PartidaXadrez partida;
    public Rei(Cor cor, Tabuleiro tabuleiro, PartidaXadrez partida) {
        super(cor, tabuleiro);
        this.partida = partida;
    }

    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        boolean[][] movs = new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];

        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();

        Tabuleiro tabuleiro = getTabuleiro();

        Posicao pos = new Posicao();

        //Uma fileira acima.
        pos.setValores(linha+1, coluna-1);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha+1, coluna);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha+1, coluna+1);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        //Mesma fileira.
        pos.setValores(linha, coluna-1);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha, coluna);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha, coluna+1);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        //Uma fileira abaixo.
        pos.setValores(linha-1, coluna-1);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha-1, coluna);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha-1, coluna+1);
        if (tabuleiro.posicaoExiste(pos) && movimentoPossivelParaoRei(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        if ((getContagemMovimentos() == 0) && naPrimeiraCasa()) {
            if (tabuleiro.haPeca(linha, 7) && tabuleiro.getPeca(linha, 7) instanceof Torre && ((PecaXadrez) tabuleiro.getPeca(linha, 7)).getContagemMovimentos() == 0 && !tabuleiro.haPeca(linha, 5) && !tabuleiro.haPeca(linha, 6))
                movs[linha][6] = true;

            if (tabuleiro.haPeca(linha, 0) && tabuleiro.getPeca(linha, 0) instanceof Torre && ((PecaXadrez) tabuleiro.getPeca(linha, 0)).getContagemMovimentos() == 0 && !tabuleiro.haPeca(linha, 1) && !tabuleiro.haPeca(linha, 2) && !tabuleiro.haPeca(linha, 3))
                movs[linha][2] = true;
            }

        return movs;
    }

    private boolean naPrimeiraCasa(){
        if (getPosicao().getColuna() != 4)
            return false;
        if (getCor() == Cor.BRANCO)
            return getPosicao().getLinha() == 0;
        return getPosicao().getLinha() == 7;
    }

    private int primeiraFileira(){
        return (getCor() == Cor.BRANCO) ? 0 : 7;
    }

    private boolean movimentoPossivelParaoRei(Posicao pos) throws ExcecaoTabuleiro {
        PecaXadrez p = (PecaXadrez) this.getTabuleiro().getPeca(pos);

        return p == null || p.getCor() != this.getCor();
    }
}
