public class Contato {


    public Contato(int codigo, String nome, int telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    private int codigo;
    private String nome;
    private int telefone;
}
