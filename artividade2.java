import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        
        // Verificar se o número é par ou ímpar
        String parOuImpar = (numero % 2 == 0) ? "par" : "ímpar";
        
        // Verificar se o número é positivo ou negativo
        String positivoOuNegativo = (numero >= 0) ? "positivo" : "negativo";
        
        // Verificar se o número é primo
        boolean isPrimo = true;
        if (numero <= 1) {
            isPrimo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    isPrimo = false;
                    break;
                }
            }
        }
        String primo = isPrimo ? "sim" : "não";
        
        // Calcular a raiz quadrada
        double raizQuadrada = Math.sqrt(numero);
        
        // Calcular o número elevado a 3
        int elevadoAoCubo = (int) Math.pow(numero, 3);
        
        // Apresentar os resultados
        System.out.println("O número é: " + parOuImpar);
        System.out.println("O número é: " + positivoOuNegativo);
        System.out.println("O número é primo: " + primo);
        System.out.println("A raiz quadrada do número: " + raizQuadrada);
        System.out.println("O número elevado a 3 é: " + elevadoAoCubo);
        
        scanner.close();
    }
}
