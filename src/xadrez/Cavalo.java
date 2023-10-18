package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Cavalo extends PecaXadrez {

    public Cavalo(Cor cor, Tabuleiro tabuleiro){
        super(cor, tabuleiro);
    }
    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        boolean[][] movs = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        Posicao pos = new Posicao();
        Tabuleiro tabuleiro = getTabuleiro();

        int linha = posicao.getLinha();
        int coluna = posicao.getColuna();

        pos.setValores(linha+1, coluna+2);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        pos.setValores(linha+1, coluna-2);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        pos.setValores(linha+2, coluna+1);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        pos.setValores(linha+2, coluna-1);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        pos.setValores(linha-1, coluna+2);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        pos.setValores(linha-1, coluna-2);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        pos.setValores(linha-2, coluna+1);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        pos.setValores(linha-2, coluna-1);
        if (tabuleiro.posicaoExiste(pos)){
            PecaXadrez peca = (PecaXadrez) tabuleiro.getPeca(pos);
            if (peca == null || (peca.getCor() != this.getCor()))
                movs[pos.getLinha()][pos.getColuna()] = true;
        }

        return movs;
    }

    @Override
    public String toString(){
        return "C";
    }
}
