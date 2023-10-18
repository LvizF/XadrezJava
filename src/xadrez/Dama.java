package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Dama extends PecaXadrez {
    public Dama(Cor cor, Tabuleiro tabuleiro){
        super(cor, tabuleiro);
    }

    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        Tabuleiro tabuleiro = getTabuleiro();
        boolean[][] movs = new boolean[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        if (posicao == null)
            posicao = posicaoAntiga;
        int linha = getPosicao().getLinha();
        int coluna = getPosicao().getColuna();

        Posicao pos = new Posicao();

        for (pos.setValores(linha+1, coluna); tabuleiro.posicaoExiste(pos); pos.setLinha(pos.getLinha()+1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        for (pos.setValores(linha-1, coluna); tabuleiro.posicaoExiste(pos); pos.setLinha(pos.getLinha()-1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        for (pos.setValores(linha, coluna+1); tabuleiro.posicaoExiste(pos); pos.setColuna(pos.getColuna()+1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        for (pos.setValores(linha, coluna-1); tabuleiro.posicaoExiste(pos); pos.setColuna(pos.getColuna()-1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        for (pos.setValores(linha+1, coluna+1); tabuleiro.posicaoExiste(pos); pos.setValores(pos.getLinha()+1, pos.getColuna()+1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        for (pos.setValores(linha+1, coluna-1); tabuleiro.posicaoExiste(pos); pos.setValores(pos.getLinha()+1, pos.getColuna()-1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        for (pos.setValores(linha-1, coluna-1); tabuleiro.posicaoExiste(pos); pos.setValores(pos.getLinha()-1, pos.getColuna()-1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        for (pos.setValores(linha-1, coluna+1); tabuleiro.posicaoExiste(pos); pos.setValores(pos.getLinha()-1, pos.getColuna()+1)){
            if (tabuleiro.haPeca(pos)){
                movs[pos.getLinha()][pos.getColuna()] = haPecaAdversaria(pos);
                break;
            }
            movs[pos.getLinha()][pos.getColuna()] = true;
        }

        return movs;
    }

    @Override
    public String toString(){
        return "D";
    }
}
