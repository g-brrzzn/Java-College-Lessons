import java.util.Scanner;
import fila.Fila;
    public class GerenciadorSenhas {

        Scanner myObj = new Scanner(System.in);
        Fila filaNormal = new Fila();
        Fila filaPreferencial = new Fila();
        int senhaAtual = 0;

        public void Menu() {
            int opcao = 0;
            do {
                System.out.println(
                        "\n\n\tGERENCIADOR DE SENHAS\n" +
                                "1. Senha Normal\n" +
                                "2. Senha Preferencial\n" +
                                "3. Chamar Senha\n" +
                                "4. Sair do Programa\n");
                try {
                    opcao = myObj.nextInt();
                } catch (Exception e)  {
                    System.out.println("\tPor favor, insira apenas números entre 1 e 4.\n");
                    opcao = 0;
                    myObj.next();
                }

                switch (opcao) {
                    case 1:
                        gerarSenhaNormal();
                        opcao = 0;
                        break;

                    case 2:
                        gerarSenhaPreferencial();
                        opcao = 0;
                        break;

                    case 3:
                        chamarSenha();
                        opcao = 0;
                        break;
                }
            } while (opcao != 4);
        }

        public void gerarSenhaNormal() {
            filaNormal.adicionar(++senhaAtual);
            System.out.println("Senha número " + senhaAtual + " adicionada à fila normal.");
        }
        public void gerarSenhaPreferencial() {
            filaPreferencial.adicionar(++senhaAtual);
            System.out.println("Senha número " + senhaAtual + " adicionada à fila preferencial.");
        }
        public Object chamarSenha() {
            if (!filaPreferencial.ehVazia()) {
                    System.out.println("\tAtenção! Chamando senha número " + filaPreferencial.pegaPrimeiro());
                    return filaPreferencial.poll();
            } else if (!filaNormal.ehVazia()){
                    System.out.println("\tAtenção! Chamando senha número " + filaNormal.pegaPrimeiro());
                    return filaNormal.poll();
                } else
                    System.out.println("\tFila vazia!");
            return null;
        }

    }

