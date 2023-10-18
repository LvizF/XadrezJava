package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Peao extends PecaXadrez{
    public Peao(Cor cor, Tabuleiro tabuleiro){
        super(cor, tabuleiro);
    }

    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        boolean[][] movs = new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];

        Posicao pos = new Posicao();
        Tabuleiro tabuleiro = getTabuleiro();
        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();

        int aux = (this.getCor() == Cor.BRANCO) ? 1 : -1;

        if (linha == 7 || linha == 0)
            return movs;

        pos.setValores(linha+aux, coluna);
        if (!tabuleiro.haPeca(pos)) {
            movs[pos.getLinha()][pos.getColuna()] = true;
            if (naPrimeiraFileira()){
                pos.setLinha(pos.getLinha()+aux);
                if (!tabuleiro.haPeca(pos))
                    movs[pos.getLinha()][pos.getColuna()] = true;

            }
        }

        pos.setValores(linha+aux, coluna+1);
        if (tabuleiro.posicaoExiste(pos) && haPecaAdversaria(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        pos.setValores(linha+aux, coluna-1);
        if (tabuleiro.posicaoExiste(pos) && haPecaAdversaria(pos))
            movs[pos.getLinha()][pos.getColuna()] = true;

        return movs;
    }

    private boolean naPrimeiraFileira(){
        if (this.getCor() == Cor.BRANCO)
            return this.posicao.getLinha() == 1;
        return this.posicao.getLinha() == 6;
    }
}
