class Adaptador implements Controlador {
    private ControleVeiculo controleVeiculo;

    public Adaptador(ControleVeiculo controleVeiculo) {
        this.controleVeiculo = controleVeiculo;
    }

    @Override
    public void obterLocalizacao() {
        controleVeiculo.obterPosicao();
    }

    @Override
    public void virarDireita() {
        controleVeiculo.rotacionar(90);
    }

    @Override
    public void virarEsquerda() {
        controleVeiculo.rotacionar(-90);
    }

    @Override
    public void setarVelocidade(int velocidade) {
        controleVeiculo.ajustarVelocidade(velocidade);
    }

    @Override
    public void parar() {
        controleVeiculo.ajustarVelocidade(0);
    }
}