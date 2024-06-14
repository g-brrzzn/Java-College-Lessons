public class PagamentoAdapter implements Pagamentos {
    private Pagamento_Operadora2 operadora2;

    public PagamentoAdapter(Pagamento_Operadora2 operadora2) {
        this.operadora2 = operadora2;
    }

    @Override
    public void entrarValor(float valor) {
        operadora2.setarQuantia(valor);
    }
    @Override
    public void entrarCodigoAutenticacao(int cod) {
        operadora2.entrarSenha(Integer.toString(cod));
    }
    @Override
    public void confirmar() {
        operadora2.confirmarCompra();
    }
}
