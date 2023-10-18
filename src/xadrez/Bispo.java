package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Bispo extends PecaXadrez {
    public Bispo(Cor cor, Tabuleiro tabuleiro){
        super(cor, tabuleiro);
    }

    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        int linhas = getTabuleiro().getLinhas();
        int colunas = getTabuleiro().getColunas();

        Tabuleiro tabuleiro = this.getTabuleiro();

        boolean[][] movs = new boolean[linhas][colunas];

        Posicao pos = new Posicao();
        pos.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
        while (tabuleiro.posicaoExiste(pos)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
            pos.setValores(pos.getLinha()+1, pos.getColuna()+1);
        }

        pos.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
        while (tabuleiro.posicaoExiste(pos)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
            pos.setValores(pos.getLinha()+1, pos.getColuna()-1);
        }

        pos.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
        while (tabuleiro.posicaoExiste(pos)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
            pos.setValores(pos.getLinha()-1, pos.getColuna()+1);
        }

        pos.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
        while (tabuleiro.posicaoExiste(pos)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
            pos.setValores(pos.getLinha()-1, pos.getColuna()-1);
        }

        return movs;
    }



    @Override
    public String toString(){
        return "B";
    }
}
