import java.util.*;
import javax.swing.JOptionPane;

public class LE3 {
    public static class MinhaClasse {
        public void metodo1() {
            System.out.println("Execução do método 1...");
        }

        public void metodo2(int valor) {
            System.out.println("Valor: " + valor);
        }
    }

    public static class MetodoAtv2 {
        public void metodo1() {
            System.out.println("Olá mundo!");
        }

        public void metodo2(int valor) {
            System.out.println("Valor + 20 = " + (valor + 20) + "!");
        }
    }

    public static class Suponhador {
        public String getString() {
            String str = JOptionPane.showInputDialog("O que você quer que eu suponhe?");
            return str;
        }

        public void supor(String str) {
            if (str != null)
                JOptionPane.showMessageDialog(null, "Eu suponho que " + str + "!", "Suponhador",
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Eu não suponho nada...", "Suponhador",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static class MedidorTemperatura {
        int temperatura;

        public void setTemperatura(int temperatura) {
            this.temperatura = temperatura;
        }

        public int getTemperatura() {
            return this.temperatura;
        }

    }

    public static class Cliente {
        String nome, endereco, telefone, email;

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void Exercicio1() {
        MinhaClasse mc = new MinhaClasse();
        mc.metodo1();
        mc.metodo2(2);
    }

    public static void Exercicio2() {
        MetodoAtv2 ma = new MetodoAtv2();
        ma.metodo1();
        ma.metodo2(50);
    }

    public static void Exercicio3() {
        Suponhador sup = new Suponhador();
        String str = sup.getString();
        sup.supor(str);
    }

    public static void Exercicio4() {
        MedidorTemperatura mt = new MedidorTemperatura();
        mt.setTemperatura(26);
        System.out.println("A temperatura está em " + mt.getTemperatura() + " graus.");
    }

    public static void Exercicio5() {
        Cliente c1 = new Cliente();
        c1.setNome("joao");
        c1.setEmail("joao.joao@joao.joao");
        c1.setEndereco("Rua Joao 123");
        c1.setTelefone("123456789");

        System.out.println("Olá " + c1.getNome() + "!\nSeu email: " + c1.getEmail() + "\nSeu telefone: "
                + c1.getTelefone() + "\nEndereço: " + c1.getEndereco());
    }

    public static void main(String args[]) {
        /*
         * Exercicio1();
         * Exercicio2();
         * Exercicio3();
         * Exercicio4();
         */
        Exercicio5();

    }
}
