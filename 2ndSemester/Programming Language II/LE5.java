import java.util.*;
import javax.swing.JOptionPane;

public class LE5 {

    public static class Pessoa {
        String nome, dataNascimento, rg;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public String getRg() {
            return rg;
        }

        public void setRg(String rg) {
            this.rg = rg;
        }
    }

    public static class Aluno extends Pessoa {
        String matricula, curso, semestreEntrada;

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public String getSemestreEntrada() {
            return semestreEntrada;
        }

        public void setSemestreEntrada(String semestreEntrada) {
            this.semestreEntrada = semestreEntrada;
        }
    }

    public static void Ex1() {
        Aluno al = new Aluno();
        String str = JOptionPane.showInputDialog("Qual seu nome?");
        al.setNome(str);
        str = JOptionPane.showInputDialog("Qual sua matricula?");
        al.setMatricula(str);
        str = JOptionPane.showInputDialog("Qual seu curso?");
        al.setCurso(str);
        str = JOptionPane.showInputDialog("Qual o mes você entrou na faculdade?");
        al.setSemestreEntrada(str);

        JOptionPane.showMessageDialog(null,
                al.getNome() + " sua matricula é: " + al.getMatricula() + " de " + al.getCurso()
                        + " que entrou no mês "
                        + al.getSemestreEntrada(),
                "Seu carro",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static class Carro {
        String velocidade, modelo, marca, preco;

        public Carro(String velocidade, String modelo, String marca, String preco) {
            this.velocidade = velocidade;
            this.modelo = modelo;
            this.marca = marca;
            this.preco = preco;
        }

        public String getVelocidade() {
            return velocidade;
        }

        public void setVelocidade(String velocidade) {
            this.velocidade = velocidade;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getPreco() {
            return preco;
        }

        public void setPreco(String preco) {
            this.preco = preco;
        }
    }

    public static class CarroCorrida extends Carro {
        String tipoAerofolio, tipoPneus, escuderia;

        public CarroCorrida(String velocidade, String modelo, String marca, String preco, String tipoAerofolio,
                String tipoPneus, String escuderia) {
            super(velocidade, modelo, marca, preco);
            this.tipoAerofolio = tipoAerofolio;
            this.tipoPneus = tipoPneus;
            this.escuderia = escuderia;
        }

        public String getTipoAerofolio() {
            return tipoAerofolio;
        }

        public void setTipoAerofolio(String tipoAerofolio) {
            this.tipoAerofolio = tipoAerofolio;
        }

        public String getTipoPneus() {
            return tipoPneus;
        }

        public void setTipoPneus(String tipoPneus) {
            this.tipoPneus = tipoPneus;
        }

        public String getEscuderia() {
            return escuderia;
        }

        public void setEscuderia(String escuderia) {
            this.escuderia = escuderia;
        }
    }

    public static void Ex2() {
        Carro carro1 = new Carro("300.00", "Cruze", "Chevrolet", "100000.00");
        CarroCorrida carro2 = new CarroCorrida("300.00", "Cruze", "Chevrolet", "100000.00", "Traseiro", "Chuva",
                "Ferrari");
        Carro carro3 = new Carro("300.00", "Cruze", "Chevrolet", "100000.00");

    }

    public static void main(String args[]) {
        // Ex1();
        Ex2();
    }
}
