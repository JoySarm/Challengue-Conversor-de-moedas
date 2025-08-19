package br.com.alura.conversores;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String chaveApi = "a5bd5f466feeb80e8b48ec71";
        int opcao = 0;

        while (opcao != 7) {
            exibirMenu();
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 7) {
                    System.out.println("Saindo do Conversor de Moedas. Até mais!");
                    break;
                }

                System.out.print("Digite o valor que deseja converter: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                ConversorDeMoedas conversor = new ConversorDeMoedas(chaveApi);

                switch (opcao) {
                    case 1:
                        conversor.converter("USD", "ARS", valor);
                        break;
                    case 2:
                        conversor.converter("ARS", "USD", valor);
                        break;
                    case 3:
                        conversor.converter("USD", "BRL", valor);
                        break;
                    case 4:
                        conversor.converter("BRL", "USD", valor);
                        break;
                    case 5:
                        conversor.converter("USD", "COP", valor);
                        break;
                    case 6:
                        conversor.converter("COP", "USD", valor);
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 7.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n***************************************************");
        System.out.println("Seja bem-vindo(a) ao Conversor de Moedas :)");
        System.out.println("1. Dólar (USD) >> Peso Argentino (ARS)");
        System.out.println("2. Peso Argentino (ARS) >> Dólar (USD)");
        System.out.println("3. Dólar (USD) >> Real Brasileiro (BRL)");
        System.out.println("4. Real Brasileiro (BRL) >> Dólar (USD)");
        System.out.println("5. Dólar (USD) >> Peso Colombiano (COP)");
        System.out.println("6. Peso Colombiano (COP) >> Dólar (USD)");
        System.out.println("7. Sair");
        System.out.println("***************************************************");
    }
}