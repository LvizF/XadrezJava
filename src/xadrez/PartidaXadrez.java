package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez() throws ExcecaoTabuleiro, ExcecaoXadrez{
        this.tabuleiro = new Tabuleiro(8, 8);
        this.posicaoInicial();
    }

    public PecaXadrez[][] getPecas() throws ExcecaoTabuleiro{
        PecaXadrez[][] matriz = new PecaXadrez[this.tabuleiro.getLinhas()][this.tabuleiro.getColunas()];
        for (int i = 0; i < this.tabuleiro.getLinhas(); i++){
            for (int j = 0; j < this.tabuleiro.getColunas(); j++){
                Posicao p = new Posicao(i, j);
                if (this.tabuleiro.haPeca(p)){
                    matriz[i][j] = (PecaXadrez) this.tabuleiro.getPeca(p);
                }
            }
        }
        return matriz;
    }

    private void colocarPeca(PecaXadrez peca, char coluna, int linha) throws ExcecaoXadrez, ExcecaoTabuleiro {
        this.tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
    }

    public void posicaoInicial() throws ExcecaoXadrez, ExcecaoTabuleiro{
        this.colocarPeca(new Rei(Cor.BRANCO, this.tabuleiro), 'e', 1);
        this.colocarPeca(new Rei(Cor.PRETO, this.tabuleiro), 'e', 8);

        this.colocarPeca(new Torre(Cor.BRANCO, this.tabuleiro), 'a', 1);
        this.colocarPeca(new Torre(Cor.BRANCO, this.tabuleiro), 'h', 1);

        this.colocarPeca(new Torre(Cor.PRETO, this.tabuleiro), 'a', 8);
        this.colocarPeca(new Torre(Cor.PRETO, this.tabuleiro), 'h', 8);
    }

    public PecaXadrez fazerMovimento(PosicaoXadrez origem, PosicaoXadrez destino) throws ExcecaoXadrez, ExcecaoTabuleiro{
        validarPosicao(origem);
        PecaXadrez pecaCapturada = realizaMovimento(origem.paraPosicao(), destino.paraPosicao());

        return pecaCapturada;
    }

    private PecaXadrez realizaMovimento(Posicao orig, Posicao dest) throws ExcecaoTabuleiro{
        PecaXadrez movente = (PecaXadrez) this.tabuleiro.getPeca(orig);
        PecaXadrez pecaCapturada = (this.tabuleiro.haPeca((dest))) ? (PecaXadrez) this.tabuleiro.getPeca(dest) : null;

        if (this.tabuleiro.haPeca(dest) && pecaCapturada.getCor() == movente.getCor())
            throw new ExcecaoXadrez("Uma peça não pode capturar outra da mesma cor.");

        this.tabuleiro.removerPeca(orig);
        if (pecaCapturada != null)
            this.tabuleiro.removerPeca(dest);

        this.tabuleiro.colocarPeca(movente, dest);

        return pecaCapturada;
    }

    private void validarPosicao(PosicaoXadrez orig) throws ExcecaoTabuleiro{
        if (!this.tabuleiro.haPeca(orig.paraPosicao()))
            throw new ExcecaoXadrez("Não há peça na posição de origem do movimento.");
    }

    public void getPeca(PosicaoXadrez pos) throws ExcecaoTabuleiro{
        PecaXadrez p = (PecaXadrez) this.tabuleiro.getPeca(pos.paraPosicao());
        System.out.printf("%s - %s\n", p, (p.getCor() == Cor.BRANCO) ? "Branco" : "Preto");
    }
}

