import java.util.*;
import javax.swing.JOptionPane;

public class LE4 {

    public static class Veiculo {
        String ano, marca, modelo, preco;

        public String getAno() {
            return ano;
        }

        public void setAno(String ano) {
            this.ano = ano;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getPreco() {
            return preco;
        }

        public void setPreco(String preco) {
            this.preco = preco;
        }
    }

    public static void main(String args[]) {

        Veiculo frota[] = new Veiculo[3];

        for (int i = 0; i <= 3; i++) {
            frota[i] = new Veiculo();
            String str = JOptionPane.showInputDialog("Qual a marca de seu carro?");
            frota[i].setMarca(str);
            str = JOptionPane.showInputDialog("Qual o modelo de seu carro?");
            frota[i].setModelo(str);
            str = JOptionPane.showInputDialog("Qual o ano de seu carro?");
            frota[i].setAno(str);
            str = JOptionPane.showInputDialog("Qual o preço de seu carro?");
            frota[i].setPreco(str);

            JOptionPane.showMessageDialog(null,
                    "Seu carro é um " + frota[i].getMarca() + " " + frota[i].getModelo() + " " + frota[i].getAno()
                            + " Avaliado no preço de "
                            + frota[i].getPreco(),
                    "Seu carro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }
}