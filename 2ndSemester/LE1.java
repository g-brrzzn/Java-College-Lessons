n/*
1) Um programa deverá possuir uma variável que armazene o salário de um funcionário. Esta variável
salario deverá ser inicializada com o valor 4500.00. Ao término do programa, o mesmo deverá exibir no
prompt de comandos o valor do salário do funcionário.
2) Crie um programa que armazene em uma variável um valor booleano, o qual corresponderá ao estado
atual de um dispositivo elétrico externo ao computador (Exemplo: um motor). Considere que o motor deverá
iniciar no estado desligado (false). Ao término do programa, o mesmo deverá exibir no prompt de comandos
o valor da variável booleana.
3) Crie um programa que possua uma variável do tipo int, e outra variável do tipo float. Inicialize a variável
do tipo float com o valor 15.0. Armazene a seguir o valor da variável do tipo float na variável do tipo int. Ao
término do programa, apresente no prompt de comandos o valor da variável do tipo int.
4) Crie um programa que possua uma variável do tipo int, e outra variável do tipo float. Inicialize a variável
do tipo int com o valor 15. Armazene a seguir o valor da variável do tipo int na variável do tipo float. Ao
término do programa, apresente no prompt de comandos o valor da variável do tipo float.
5) Apresente um programa que converta um valor do tipo double em um valor do tipo int. Inicialize a
variável do tipo double com o valor 17.8. Armazene a seguir o valor da variável double na variável do tipo
int. Ao término do programa, apresente no prompt de comandos o valor da variável do tipo int, e interprete
o resultado.
6) Crie um programa que declare uma variável do tipo vetor com três posições do tipo int. Em seguida,
inicialize cada uma das posições do vetor com os valores 6, 9 e 13. Imprima as posições do vetor.
7) Um programa deverá registrar o nome e o cpf de pessoas participantes de um evento. Elabore uma
rotina que leia o valor do nome do participante, em seguida seu CPF, salve os dados de alguma forma (em
um vetor, por Exemplo). Considere um número fixo de 10 participantes para este evento. Ao final, exiba os
dados de cada participante.
Sugestão: crie uma classe Participante, que possua os atributos nome e cpf. Em seguida, salve
cada objeto do tipo Participante em um vetor.
8) Crie um programa que declare uma variável do tipo vetor com três posições do tipo String. Em seguida,
inicialize cada uma das posições do vetor com os valores “Antônio da Silva”, “Maria Eduarda” e “Carlos
Ricardo”. Imprima as posições do vetor.
*/

import java.util.*;

import javax.naming.InterruptedNamingException;
import javax.swing.JOptionPane;

public class LE1 {

    public static void Exemplo() {
        int idade;
        String idadeS;
        idadeS = JOptionPane.showInputDialog("Entre com sua idade: ");
        idade = Integer.parseInt(idadeS);
        idade = idade + 10;
        System.out.println("Daqui a dez anos você terá: " + idade + " anos de idade.");
        JOptionPane.showMessageDialog(null, "Daqui a dez anos você terá: " + idade + " anos de idade.");
    }

    public static void Exercicio1() {
        double salario = 4500.00;
        System.out.println("Seu salário é: " + salario);
    }

    public static void Exercicio2() {
        boolean ligado = false;
        System.out.println("O motor está ligado: " + ligado);
    }

    public static void Exercicio3() {
        float valor1 = 15.0f;
        int valor2 = (int) valor1;
        System.out.println("O valor 1 é " + valor1 + " e o valor 2 é " + valor2);
    }

    public static void Exercicio4() {
        double valor1 = 15.0;
        int valor2 = (int) valor1;
        System.out.println("O valor 1 é " + valor1 + " e o valor 2 é " + valor2);
    }

    public static void Exercicio5() {
        int valor1 = 15;
        float valor2 = (float) valor1;
        System.out.println("O valor 1 é " + valor1 + " e o valor 2 é " + valor2);
    }

    public static void Exercicio6() {
        Vector lista = new Vector();
        lista.add(0, 6);
        lista.add(1, 9);
        lista.add(2, 13);
        System.out.println("Os valores da lista é: " + lista);
    }

    public static void Exercicio7() {
        int qnt = 3;
        String nome[] = new String[50];
        String cpf[] = new String[20];

        System.out.println("\tRegistrador de nome e CPF");
        Scanner Sc = new Scanner(System.in);

        for (int i = 0; i <= qnt; i++) {
            System.out.print("Seu nome: ");
            nome[i] = Sc.nextLine();
            System.out.print("Seu CPF: ");
            cpf[i] = Sc.nextLine();
        }

        System.out.println("\tDados Salvos!");
        System.out.println("\tMostrando dados");

        for (int i = 0; i <= qnt; i++)
            System.out.println("\t" + nome[i] + " - " + cpf[i]);
    }

    public static void Exercicio8() {
        String[] nomes = { "Antônio da Silva", "Maria Eduarda", "Carlos Ricardo" };

        for (String i : nomes)
            System.out.println(i);

    }

    public static void main(String args[]) {
        /*
         * Exercicio1();
         * Exercicio2();
         * Exercicio3();
         * Exercicio4();
         * Exercicio5();
         * Exercicio6();
         * Exercicio7();
         * Exercicio8();
         */

    }
}
