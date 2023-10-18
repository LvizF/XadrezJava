package xadrez;

import application.Interface;
import tabuleiro.ExcecaoTabuleiro;
import tabuleiro.Peca;
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
    private boolean xequeMate;

    public PartidaXadrez() throws ExcecaoTabuleiro, ExcecaoXadrez{
        this.tabuleiro = new Tabuleiro(8, 8);
        this.turno = 1;
        this.jogadorAtual = Cor.BRANCO;
        this.pecasCapturadas = new ArrayList<PecaXadrez>();
        this.pecasNoTabuleiro = new ArrayList<PecaXadrez>();
        this.posicaoInicial();
        if (verificaXeque(Cor.PRETO) && jogadorAtual == Cor.BRANCO)
            throw new IllegalStateException("As pretas começam em xeque, mas jogam primeiro as brancas.\n");
        if (verificaXeque(Cor.BRANCO) && jogadorAtual == Cor.PRETO)
            throw new IllegalStateException("As brancas começam em xeque, mas jogam primeiro as pretas.\n");
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

    private void colocarPeca(PecaXadrez peca, char coluna, int linha) throws ExcecaoTabuleiro {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
        this.pecasNoTabuleiro.add(peca);
    }

    private void colocarPeca(PecaXadrez peca, Posicao pos) throws ExcecaoTabuleiro {
        tabuleiro.colocarPeca(peca, pos);
        this.pecasNoTabuleiro.add(peca);
    }

    private PecaXadrez retirarPeca(Posicao pos) throws ExcecaoTabuleiro{
        PecaXadrez peca = (PecaXadrez) tabuleiro.removerPeca(pos);
        this.pecasNoTabuleiro.remove(peca);

        return peca;
    }

    public void posicaoInicial() throws ExcecaoTabuleiro{
        this.colocarPeca(new Rei(Cor.BRANCO, this.tabuleiro, this), 'e', 1);
        this.colocarPeca(new Rei(Cor.PRETO, this.tabuleiro, this), 'e', 8);

        this.colocarPeca(new Torre(Cor.BRANCO, this.tabuleiro), 'a', 1);
        this.colocarPeca(new Torre(Cor.BRANCO, this.tabuleiro), 'h', 1);

        this.colocarPeca(new Torre(Cor.PRETO, this.tabuleiro), 'a', 8);
        this.colocarPeca(new Torre(Cor.PRETO, this.tabuleiro), 'h', 8);

        this.colocarPeca(new Cavalo(Cor.PRETO, this.tabuleiro), 'e', 3);
        this.colocarPeca(new Cavalo(Cor.BRANCO, this.tabuleiro), 'e', 6);

        /*
        this.colocarPeca(new Dama(Cor.BRANCO, this.tabuleiro), 'd', 1);
        this.colocarPeca(new Dama(Cor.PRETO, this.tabuleiro), 'd', 8);

        this.colocarPeca(new Cavalo(Cor.BRANCO, this.tabuleiro), 'b', 1);
        this.colocarPeca(new Cavalo(Cor.BRANCO, this.tabuleiro), 'g', 1);

        this.colocarPeca(new Bispo(Cor.BRANCO, this.tabuleiro), 'c', 1);
        this.colocarPeca(new Bispo(Cor.BRANCO, this.tabuleiro), 'f', 1);

        this.colocarPeca(new Cavalo(Cor.PRETO, this.tabuleiro), 'b', 8);
        this.colocarPeca(new Cavalo(Cor.PRETO, this.tabuleiro), 'g', 8);

        this.colocarPeca(new Bispo(Cor.PRETO, this.tabuleiro), 'c', 8);
        this.colocarPeca(new Bispo(Cor.PRETO, this.tabuleiro), 'f', 8);*/

        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'a', 7);
        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'b', 7);
        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'c', 7);
        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'd', 7);
        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'e', 7);
        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'f', 7);
        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'g', 7);
        this.colocarPeca(new Peao(Cor.PRETO, this.tabuleiro), 'h', 7);

        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'a', 2);
        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'b', 2);
        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'c', 2);
        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'e', 2);
        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'd', 2);
        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'f', 2);
        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'g', 2);
        this.colocarPeca(new Peao(Cor.BRANCO, this.tabuleiro), 'h', 2);
    }


    public PecaXadrez fazerMovimento(PosicaoXadrez origem, PosicaoXadrez destino) throws ExcecaoTabuleiro{
        validarPosicaoOrigem(origem);

        validarPosicaoDestino(origem.paraPosicao(), destino.paraPosicao());

        PecaXadrez pecaCapturada = realizaMovimento(origem.paraPosicao(), destino.paraPosicao());
        if (pecaCapturada != null) {
            this.pecasNoTabuleiro.remove(pecaCapturada);
            this.pecasCapturadas.add(pecaCapturada);
        }

        if (verificaXeque(this.jogadorAtual)){
            desfazerMovimento(origem.paraPosicao(), destino.paraPosicao(), pecaCapturada);
            if (pecaCapturada != null) {
                pecasCapturadas.remove(pecaCapturada);
                pecasNoTabuleiro.add(pecaCapturada);
            }
            throw new ExcecaoXadrez(String.format("Movimento ilegal, pois que põe o rei %s em xeque ou não o protege.", (this.jogadorAtual == Cor.BRANCO) ? "branco" : "preto"));
        }


        xeque = (verificaXeque(oponente(this.jogadorAtual)));
        xequeMate = verificaXequeMate(oponente(jogadorAtual));

        if (!xequeMate)
            proximoTurno();

        return pecaCapturada;
    }

    private PecaXadrez realizaMovimento(Posicao orig, Posicao dest) throws ExcecaoTabuleiro{
        PecaXadrez movente = (PecaXadrez) tabuleiro.getPeca(orig);
        PecaXadrez pecaCapturada = (tabuleiro.haPeca((dest))) ? (PecaXadrez) this.tabuleiro.getPeca(dest) : null;

        if (tabuleiro.haPeca(dest) && pecaCapturada.getCor() == movente.getCor())
            throw new ExcecaoXadrez("Uma peça não pode capturar outra da mesma cor.");

        if (movente instanceof Rei && orig.getColuna() == 4 && dest.getColuna() == 6){
            if (!seguroParaORei(new Posicao(orig.getLinha(), 5), movente.getCor()) || !seguroParaORei(new Posicao(orig.getLinha(), 6), movente.getCor()))
                throw new ExcecaoXadrez("O roque não é permitido.");
            realizaMovimento(new Posicao(orig.getLinha(), 7), new Posicao(orig.getLinha(), dest.getColuna()-1));
        }

        if (movente instanceof Rei && orig.getColuna() == 4 && dest.getColuna() == 2){
            if (!seguroParaORei(new Posicao(orig.getLinha(), 2), movente.getCor()) || !seguroParaORei(new Posicao(orig.getLinha(), 3), movente.getCor()))
                throw new ExcecaoXadrez("O roque não é permitido.");
            realizaMovimento(new Posicao(orig.getLinha(), 0), new Posicao(orig.getLinha(), dest.getColuna()+1));
        }

        tabuleiro.removerPeca(orig);

        if (pecaCapturada != null)
            tabuleiro.removerPeca(dest);


        tabuleiro.colocarPeca(movente, dest);
        movente.aumentarContagemMovimentos();

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
            throw new ExcecaoTabuleiro(String.format("Há um %s na posição de origem, %s.", tabuleiro.getPeca(orig), orig));

        PecaXadrez pecaDest = (PecaXadrez) tabuleiro.removerPeca(dest);
        if (pecaDest instanceof Rei && orig.getColuna() == 4 && dest.getColuna() == 6){
            Posicao posTorre = new Posicao(dest.getLinha(), dest.getColuna()-1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.getPeca(posTorre);
            if (torre == null)
                throw new ExcecaoXadrez("Impossível desfazer movimento.");
            desfazerMovimento(new Posicao(posTorre.getLinha(), 7), posTorre, null);
        }

        if (pecaDest instanceof Rei && orig.getColuna() == 4 && dest.getColuna() == 2){
            Posicao posTorre = new Posicao(dest.getLinha(), dest.getColuna()+1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.getPeca(posTorre);
            if (torre == null)
                throw new ExcecaoXadrez("Impossível desfazer movimento.");
            desfazerMovimento(new Posicao(posTorre.getLinha(), 0), posTorre, null);
        }

        tabuleiro.colocarPeca(pecaDest, orig);
        pecaDest.setPosicao(orig);


        ((PecaXadrez) tabuleiro.getPeca(orig)).reduzirContagemMovimentos();

        if (pecaCapturada != null) {
            tabuleiro.colocarPeca(pecaCapturada, dest);
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

    private PecaXadrez rei(Cor cor) {
        for (PecaXadrez p : pecasNoTabuleiro)
            if (p instanceof Rei && p.getCor() == cor)
                return p;

        throw new IllegalStateException(String.format("Não há rei %s no tabuleiro.", (cor == Cor.BRANCO) ? "branco" : "preto"));
    }

    protected boolean verificaXeque(Cor cor) throws ExcecaoTabuleiro {
        Posicao reiPosicao = rei(cor).getPosicaoXadrez().paraPosicao();
        return !seguroParaORei(reiPosicao, cor);
    }

    protected boolean seguroParaORei(Posicao pos, Cor cor) throws ExcecaoTabuleiro {
        for (PecaXadrez peca : this.pecasNoTabuleiro)
            if (peca.getCor() == oponente(cor) && peca.movimentoPossivel(pos))
                return false;
        return true;
    }

    private boolean verificaXequeMate(Cor cor) throws ExcecaoTabuleiro{
        if (!verificaXeque(cor))
            return false;

        ArrayList<PecaXadrez> pecasCor = new ArrayList<PecaXadrez>();
        for (PecaXadrez p : pecasNoTabuleiro)
            if (p.getCor() == cor)
                pecasCor.add(p);

        for (PecaXadrez peca : pecasCor){
            boolean[][] movs = peca.movimentosPossiveis();
            for (int i = 0; i < tabuleiro.getLinhas(); i++){
                for (int j = 0; j < tabuleiro.getColunas(); j++){
                    if (movs[i][j]){
                        Posicao dest = new Posicao(i, j);
                        Posicao orig = peca.getPosicaoXadrez().paraPosicao();
                        PecaXadrez pecaCapta = realizaMovimento(orig, dest);

                        boolean xeque = verificaXeque(cor);
                        desfazerMovimento(orig, dest, pecaCapta);
                        if (!xeque)
                            return false;
                    }
                }
            }
        }

        return true;
    }

    private Cor oponente(Cor cor){
        return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
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

    public ArrayList<PecaXadrez> getPecasNoTabuleiro() {
        return this.pecasNoTabuleiro;
    }

    public boolean getXeque() {
        return xeque;
    }

    private void setXequeMate(){
        this.xequeMate = true;
    }

    public boolean getXequeMate(){
        return this.xequeMate;
    }
}

