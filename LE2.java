import java.util.*;
import javax.swing.JOptionPane;

public class LE2 {

    public static class Carro {
        String marca;
        String modelo;
        String cor;

        public Carro(String marca, String modelo, String cor) {
            this.marca = marca;
            this.modelo = modelo;
            this.cor = cor;
        }

        void ligar() {
            //
        }

        void desligar() {
            //
        }

        void acelerar() {
            //
        }

        void frear() {
            //
        }
    }

    public static void Exercicio1() {
        Carro JettaPreto = new Carro("Volkswagen", "Jetta", "Preto");

        System.out.println("\tCriando seu carro!");
        String marca = JOptionPane.showInputDialog("Diga a marca do seu carro");
        String modelo = JOptionPane.showInputDialog("Diga o modelo do seu carro");
        String cor = JOptionPane.showInputDialog("Diga a cor do seu carro");

        Carro SeuCarro = new Carro(marca, modelo, cor);
        System.out.println("Seu carro é um " + SeuCarro.marca + " " + SeuCarro.modelo + " " + SeuCarro.cor);
    }

    public static class Aluno {
        String nome;
        String matricula;

        public Aluno(String nome, String matricula) {
            this.nome = nome;
            this.matricula = matricula;
        }
    }

    public static void Exercicio2() {
        String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
        String matricula = JOptionPane.showInputDialog("Qual a matricula do aluno?");

        Aluno a1 = new Aluno(nome, matricula);
        System.out.println("O aluno é " + a1.nome + " - " + a1.matricula);
    }

    public static void main(String args[]) {
        /*
         * Exercicio1();
         */
        Exercicio2();

    }
}
