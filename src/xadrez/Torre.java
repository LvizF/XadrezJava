package xadrez;
import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Torre extends PecaXadrez{
    public Torre(Cor cor, Tabuleiro tabuleiro) {
        super(cor, tabuleiro);
    }

    public String toString(){
        return "T";
    }

    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        boolean[][] movs = new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];

        int linha = this.posicao.getLinha();
        int coluna = this.posicao.getColuna();

        Posicao p = new Posicao();

        for (p.setValores(linha+1, coluna); this.getTabuleiro().posicaoExiste(p); p.setLinha(p.getLinha()+1)){
            if (this.getTabuleiro().haPeca(p)){
                if (this.haPecaAdversaria(p))
                    movs[p.getLinha()][p.getColuna()] = true;
                break;
            }
            movs[p.getLinha()][p.getColuna()] = true;
        }

        for (p.setValores(linha-1, coluna); this.getTabuleiro().posicaoExiste(p); p.setLinha(p.getLinha()-1)){
            if (this.getTabuleiro().haPeca(p)){
                if (this.haPecaAdversaria(p))
                    movs[p.getLinha()][p.getColuna()] = true;
                break;
            }
            movs[p.getLinha()][p.getColuna()] = true;
        }

        for (p.setValores(linha, coluna+1); this.getTabuleiro().posicaoExiste(p); p.setColuna(p.getColuna()+1)){
            if (this.getTabuleiro().haPeca(p)){
                if (this.haPecaAdversaria(p))
                    movs[p.getLinha()][p.getColuna()] = true;
                break;
            }
            movs[p.getLinha()][p.getColuna()] = true;
        }

        for (p.setValores(linha, coluna-1); this.getTabuleiro().posicaoExiste(p); p.setColuna(p.getColuna()-1)){
            if (this.getTabuleiro().haPeca(p)){
                if (this.haPecaAdversaria(p))
                    movs[p.getLinha()][p.getColuna()] = true;
                break;
            }
            movs[p.getLinha()][p.getColuna()] = true;
        }

        return movs;
    }
}
