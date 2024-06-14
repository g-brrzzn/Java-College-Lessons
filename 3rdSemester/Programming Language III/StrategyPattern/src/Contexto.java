public class Contexto {
    private Estrategia estrategia;

    public void escolherEstrategia(int numEstrategia) {
        switch (numEstrategia) {
            case 1:
                estrategia = new Estrategia1();
                break;
            case 2:
                estrategia = new Estrategia2();
                break;
            default:
                throw new IllegalArgumentException("Estratégia inválida");
        }
    }

    public void executarEstrategia() {
        if (estrategia != null) {
            estrategia.realizarOperacao();
        } else {
            System.out.println("Nenhuma estratégia foi escolhida.");
        }
    }
}
