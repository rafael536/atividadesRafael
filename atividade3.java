import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> medias = new ArrayList<>();
        
        while (true) {
            System.out.print("Digite o nome do aluno (ou 'fim' para encerrar): ");
            String nome = scanner.nextLine();
            
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }
            
            double soma = 0;
            for (int i = 1; i <= 4; i++) {
                System.out.print("Digite a nota " + i + " do aluno " + nome + ": ");
                double nota = scanner.nextDouble();
                soma += nota;
            }
            scanner.nextLine(); // Limpar o buffer
            
            double media = soma / 4;
            nomes.add(nome);
            medias.add(media);
        }
        
        // Calcular a média geral da turma
        double somaMedias = 0;
        for (double media : medias) {
            somaMedias += media;
        }
        double mediaGeral = somaMedias / medias.size();
        
        // Apresentar os resultados
        System.out.println("\nResultados:");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.printf("%s - Média: %.2f - Situação: %s%n", 
                              nomes.get(i), medias.get(i), 
                              (medias.get(i) >= 7 ? "Aprovado" : "Reprovado"));
        }
        
        System.out.printf("\nMédia geral da turma: %.2f%n", mediaGeral);
        
        // Contar aprovados e reprovados
        int aprovados = 0, reprovados = 0;
        for (double media : medias) {
            if (media >= 7) {
                aprovados++;
            } else {
                reprovados++;
            }
        }
        
        System.out.println("Total de aprovados: " + aprovados);
        System.out.println("Total de reprovados: " + reprovados);
        
        scanner.close();
    }
}
