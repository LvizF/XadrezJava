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

        for (int i = linha+1; i < 8; i++){
            if (this.getTabuleiro().haPeca(i, coluna)){
                if (((PecaXadrez) this.getTabuleiro().getPeca(i, coluna)).getCor() != this.getCor())
                    movs[i][coluna] = true;
                break;
            }
            movs[i][coluna] = true;
        }

        for (int i = linha-1; i >= 0; i--){
            if (this.getTabuleiro().haPeca(i, coluna)){
                if (((PecaXadrez) this.getTabuleiro().getPeca(i, coluna)).getCor() != this.getCor())
                    movs[i][coluna] = true;
                break;
            }
            movs[i][coluna] = true;
        }

        for (int i = coluna+1; i < 8; i++){
            if (this.getTabuleiro().haPeca(linha, i)){
                if (((PecaXadrez) this.getTabuleiro().getPeca(linha, i)).getCor() != this.getCor())
                    movs[linha][i] = true;
                break;
            }
            movs[linha][i] = true;
        }

        for (int i = coluna-1; i >= 0; i--){
            if (this.getTabuleiro().haPeca(linha, i)){
                if (((PecaXadrez) this.getTabuleiro().getPeca(linha, i)).getCor() != this.getCor())
                    movs[linha][i] = true;
                break;
            }
            movs[linha][i] = true;
        }

        return movs;
    }
}
