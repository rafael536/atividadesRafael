import java.util.Scanner;

public class ExerciciosJava {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Escolha o exercício que deseja executar:");
            System.out.println("1 - Exercício 1 (Informações sobre uma palavra)");
            System.out.println("2 - Exercício 2 (Informações sobre um número)");
            System.out.println("3 - Exercício 3 (Cálculo de valor com desconto)");
            System.out.println("4 - Exercício 4 (Notas dos alunos)");
            System.out.println("5 - Exercício 5 (Conceito de nota)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            
            switch (opcao) {
                case 1:
                    exercicio1(scanner);
                    break;
                case 2:
                    exercicio2(scanner);
                    break;
                case 3:
                    exercicio3(scanner);
                    break;
                case 4:
                    exercicio4(scanner);
                    break;
                case 5:
                    exercicio5(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        }
    }

    public static void exercicio1(Scanner scanner) {
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        System.out.println("A palavra digitada foi: " + palavra);
        System.out.println("A palavra tem " + palavra.length() + " dígitos");
        System.out.println("Primeira letra: " + palavra.charAt(0));
        System.out.println("Última letra: " + palavra.charAt(palavra.length() - 1));
        
        if (palavra.length() % 2 != 0) {
            System.out.println("Letra central da palavra: " + palavra.charAt(palavra.length() / 2));
        } else {
            System.out.println("A palavra tem número par de letras, não há letra central exata.");
        }
        
        System.out.println("A palavra escrita ao contrário é: " + new StringBuilder(palavra).reverse().toString());
        System.out.println("A palavra toda em maiúsculo: " + palavra.toUpperCase());
        System.out.println("A palavra toda em minúsculo: " + palavra.toLowerCase());
    }

    public static void exercicio2(Scanner scanner) {
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        System.out.println("O número é " + (numero % 2 == 0 ? "par" : "ímpar"));
        System.out.println("O número é " + (numero >= 0 ? "positivo" : "negativo"));
        System.out.println("O número é " + (isPrimo(numero) ? "primo" : "não é primo"));
        System.out.println("A raiz quadrada do número: " + Math.sqrt(numero));
        System.out.println("O número elevado a 3: " + Math.pow(numero, 3));
    }

    public static boolean isPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void exercicio3(Scanner scanner) {
        System.out.print("Digite o valor cheio da compra: ");
        double valorCheio = scanner.nextDouble();
        System.out.print("Digite o valor do desconto: ");
        double desconto = scanner.nextDouble();

        double valorNovo = valorCheio - desconto;
        
        System.out.println("O valor cheio é: " + valorCheio);
        System.out.println("O valor do desconto é: " + desconto);
        System.out.println("O valor novo é: " + valorNovo);
    }

    public static void exercicio4(Scanner scanner) {
        double[] notas = new double[5];
        double soma = 0;
        
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }
        
        double maiorNota = notas[0];
        double menorNota = notas[0];
        
        for (double nota : notas) {
            if (nota > maiorNota) maiorNota = nota;
            if (nota < menorNota) menorNota = nota;
        }
        
        double media = soma / notas.length;
        
        System.out.println("A maior nota é: " + maiorNota);
        System.out.println("A menor nota é: " + menorNota);
        System.out.println("A média da turma é: " + media);
    }

    public static void exercicio5(Scanner scanner) {
        System.out.print("Digite a nota (0 a 100): ");
        int nota = scanner.nextInt();
        String conceito;

        if (nota > 90) {
            conceito = "A";
        } else if (nota > 80) {
            conceito = "B";
        } else if (nota > 70) {
            conceito = "C";
        } else if (nota > 60) {
            conceito = "D";
        } else {
            conceito = "E";
        }
        
        System.out.println("O conceito é: " + conceito);
    }
}
