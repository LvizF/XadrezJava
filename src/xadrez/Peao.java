package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

import static java.lang.Math.abs;

public class Peao extends PecaXadrez{
    private PartidaXadrez partida;
    public Peao(Cor cor, Tabuleiro tabuleiro, PartidaXadrez partida){
        super(cor, tabuleiro);
        this.partida = partida;
    }

    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] movimentosPossiveis() throws ExcecaoTabuleiro {
        boolean[][] movs = new boolean[this.getTabuleiro().getLinhas()][this.getTabuleiro().getColunas()];

        Posicao pos = new Posicao();
        Tabuleiro tabuleiro = getTabuleiro();
        //Gambiarra para consertar exceção. Não sei por que funciona, mas funciona.
        if (this.posicao == null)
            setPosicao(posicaoAntiga);
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

        PecaXadrez peao = partida.getVulneravelEnPassant();
        if (peao != null && peao.getCor() != this.getCor() && abs(peao.getPosicao().getColuna() - coluna) == 1 && peao.getPosicao().getLinha() == linha){
            movs[linha+aux][peao.getPosicao().getColuna()] = true;
        }

        return movs;
    }

    private boolean naPrimeiraFileira() {
        if (this.getCor() == Cor.BRANCO)
            return this.posicao.getLinha() == 1;
        return this.posicao.getLinha() == 6;
    }
}
