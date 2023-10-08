package xadrez;

import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

import java.util.ArrayList;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;
    private int turno;
    private Cor jogadorAtual;
    private ArrayList<PecaXadrez> pecasCapturadas;
    private ArrayList<PecaXadrez> pecasNoTabuleiro;
    private boolean xeque;

    public PartidaXadrez() throws ExcecaoTabuleiro, ExcecaoXadrez{
        this.tabuleiro = new Tabuleiro(8, 8);
        this.turno = 1;
        this.jogadorAtual = Cor.BRANCO;
        this.pecasCapturadas = new ArrayList<PecaXadrez>();
        this.pecasNoTabuleiro = new ArrayList<PecaXadrez>();
        this.posicaoInicial();
    }

    public PecaXadrez[][] getPecas() throws ExcecaoTabuleiro{
        PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++){
            for (int j = 0; j < tabuleiro.getColunas(); j++){
                Posicao p = new Posicao(i, j);
                if (this.tabuleiro.haPeca(p)){
                    matriz[i][j] = (PecaXadrez) tabuleiro.getPeca(p);
                }
            }
        }
        return matriz;
    }

    private void colocarPeca(PecaXadrez peca, char coluna, int linha) throws ExcecaoXadrez, ExcecaoTabuleiro {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
        this.pecasNoTabuleiro.add(peca);
    }

    public void posicaoInicial() throws ExcecaoTabuleiro{
        this.colocarPeca(new Rei(Cor.BRANCO, this.tabuleiro), 'e', 1);
        this.colocarPeca(new Rei(Cor.PRETO, this.tabuleiro), 'e', 8);

        this.colocarPeca(new Torre(Cor.BRANCO, this.tabuleiro), 'a', 1);
        this.colocarPeca(new Torre(Cor.BRANCO, this.tabuleiro), 'h', 1);

        this.colocarPeca(new Torre(Cor.PRETO, this.tabuleiro), 'a', 8);
        this.colocarPeca(new Torre(Cor.PRETO, this.tabuleiro), 'h', 8);

        this.colocarPeca(new Rei(Cor.PRETO, this.tabuleiro), 'h', 5);
        this.colocarPeca(new Rei(Cor.BRANCO, this.tabuleiro), 'a', 5);
    }

    public PecaXadrez fazerMovimento(PosicaoXadrez origem, PosicaoXadrez destino) throws ExcecaoXadrez, ExcecaoTabuleiro{
        validarPosicaoOrigem(origem);

        validarPosicaoDestino(origem.paraPosicao(), destino.paraPosicao());

        PecaXadrez pecaCapturada = realizaMovimento(origem.paraPosicao(), destino.paraPosicao());

        if (pecaCapturada != null){
            this.pecasCapturadas.add(pecaCapturada);
            this.pecasNoTabuleiro.remove(pecaCapturada);
        }

        proximoTurno();

        return pecaCapturada;
    }

    private PecaXadrez realizaMovimento(Posicao orig, Posicao dest) throws ExcecaoTabuleiro{
        PecaXadrez movente = (PecaXadrez) tabuleiro.getPeca(orig);
        PecaXadrez pecaCapturada = (tabuleiro.haPeca((dest))) ? (PecaXadrez) this.tabuleiro.getPeca(dest) : null;

        if (tabuleiro.haPeca(dest) && pecaCapturada.getCor() == movente.getCor())
            throw new ExcecaoXadrez("Uma peça não pode capturar outra da mesma cor.");

        tabuleiro.removerPeca(orig);
        if (pecaCapturada != null)
            tabuleiro.removerPeca(dest);

        tabuleiro.colocarPeca(movente, dest);

        return pecaCapturada;
    }

    private void validarPosicaoOrigem(PosicaoXadrez orig) throws ExcecaoTabuleiro{
        if (!tabuleiro.haPeca(orig.paraPosicao()))
            throw new ExcecaoXadrez(String.format("Não há peça na posição %s.", orig));

        if (((PecaXadrez) tabuleiro.getPeca(orig.paraPosicao())).getCor() != this.jogadorAtual)
            throw new ExcecaoXadrez(String.format("Não é turno das %s.", (((PecaXadrez) tabuleiro.getPeca(orig.paraPosicao())).getCor() == Cor.BRANCO) ? "brancas" : "pretas"));

        if (!tabuleiro.getPeca(orig.paraPosicao()).haAlgumMovimentoPossivel())
            throw new ExcecaoXadrez("A peça escolhida não pode realizar nenhum movimento.");
    }

    private void validarPosicaoDestino(Posicao orig, Posicao dest) throws ExcecaoTabuleiro{
        if (!tabuleiro.getPeca(orig).movimentoPossivel(dest))
            throw new ExcecaoXadrez("Movimento ilegal.");
    }

    private void desfazerMovimento(Posicao orig, Posicao dest, PecaXadrez pecaCapturada) throws ExcecaoTabuleiro{
        if (!tabuleiro.haPeca(dest))
            throw new ExcecaoTabuleiro(String.format("Não há peça em %s.", dest));

        if (tabuleiro.haPeca(orig))
            throw new ExcecaoTabuleiro("Há uma peça na posição de origem.");

        tabuleiro.colocarPeca(tabuleiro.getPeca(dest), orig);
        if (pecaCapturada != null) {
            tabuleiro.colocarPeca(pecaCapturada, orig);
            pecasCapturadas.remove(pecaCapturada);
            pecasNoTabuleiro.add(pecaCapturada);
        }
    }

    public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem) throws ExcecaoTabuleiro{
        if (!tabuleiro.haPeca(posicaoOrigem.paraPosicao()))
            throw new ExcecaoXadrez(String.format("Peça não há na posição %s.", posicaoOrigem));

        validarPosicaoOrigem(posicaoOrigem);

        return tabuleiro.getPeca(posicaoOrigem.paraPosicao()).movimentosPossiveis();
    }

    private void proximoTurno(){
        this.jogadorAtual = oponente(this.jogadorAtual);
        if (this.jogadorAtual == Cor.BRANCO)
            this.turno++;
    }

    private PecaXadrez rei(Cor cor){
        for (PecaXadrez p : pecasNoTabuleiro)
            if (p instanceof Rei && p.getCor() == cor)
                return p;
        throw new IllegalStateException(String.format("Não há rei %s no tabuleiro.", (cor == Cor.BRANCO) ? "branco" : "preto"));
    }

    public int getTurno() {
        return turno;
    }

    public Cor getJogadorAtual() {
        return jogadorAtual;
    }

    public ArrayList<PecaXadrez> getPecasCapturadas() {
        return this.pecasCapturadas;
    }

    private Cor oponente(Cor cor){
        return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
    }
}

