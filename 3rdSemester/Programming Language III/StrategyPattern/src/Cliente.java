public class Cliente {
    public static void main(String[] args) {
        Contexto contexto = new Contexto();

        contexto.escolherEstrategia(1);
        contexto.executarEstrategia();
    }
}
