

public class Cliente {
    public static void main(String[] args) {

        ControleVeiculo controleVeiculo = new ControleVeiculo();
        Controlador adaptador = new Adaptador(controleVeiculo);

        adaptador.obterLocalizacao();
        adaptador.virarDireita();
        adaptador.setarVelocidade(50);
        adaptador.parar();
    }
}
