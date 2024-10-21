import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Pessoa {
    private int idPessoa;
    private String nomePessoa;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(int idPessoa, String nomePessoa, String cpf, LocalDate dataNascimento) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getIdPessoa() { return idPessoa; }
    public void setIdPessoa(int idPessoa) { this.idPessoa = idPessoa; }
    public String getNomePessoa() { return nomePessoa; }
    public void setNomePessoa(String nomePessoa) { this.nomePessoa = nomePessoa; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}

class Aluno extends Pessoa {
    private String nota;

    public Aluno(int idPessoa, String nomePessoa, String cpf, LocalDate dataNascimento, String nota) {
        super(idPessoa, nomePessoa, cpf, dataNascimento);
        this.nota = nota;
    }

    public String getNota() { return nota; }
    public void setNota(String nota) { this.nota = nota; }

    public String getConceito() {
        double notaDouble = Double.parseDouble(nota);
        if (notaDouble >= 90) return "A";
        else if (notaDouble >= 80) return "B";
        else if (notaDouble >= 70) return "C";
        else if (notaDouble >= 60) return "D";
        else return "E";
    }
}

class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(int idPessoa, String nomePessoa, String cpf, LocalDate dataNascimento, String cargo, double salario) {
        super(idPessoa, nomePessoa, cpf, dataNascimento);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public double aplicarReajuste(double percentual) {
        return salario + (salario * percentual / 100);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Cadastrar aluno");
            System.out.println("3. Cadastrar funcionário");
            System.out.println("4. Listar pessoas");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (opcao) {
                case 1:
                    cadastrarPessoa(scanner, pessoas);
                    break;
                case 2:
                    cadastrarAluno(scanner, pessoas);
                    break;
                case 3:
                    cadastrarFuncionario(scanner, pessoas);
                    break;
                case 4:
                    listarPessoas(pessoas);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarPessoa(Scanner scanner, ArrayList<Pessoa> pessoas) {
        System.out.print("Digite o ID da pessoa: ");
        int idPessoa = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = scanner.nextLine();

        System.out.print("Digite o CPF da pessoa: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a data de nascimento da pessoa (DD/MM/AAAA): ");
        String dataNascimentoString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, formatter);

        Pessoa pessoa = new Pessoa(idPessoa, nomePessoa, cpf, dataNascimento);
        pessoas
