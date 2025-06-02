import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();
        dao.criarTabela();

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 6) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - Listar todos os alunos");
            System.out.println("3 - Buscar aluno por ID");
            System.out.println("4 - Atualizar aluno");
            System.out.println("5 - Deletar aluno");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Curso: ");
                    String curso = sc.nextLine();

                    Aluno aluno = new Aluno(id, nome, idade, curso);
                    dao.inserir(aluno);
                }
                case 2 -> {
                    List<Aluno> alunos = dao.listarTodos();
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado.");
                    } else {
                        alunos.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("ID do aluno: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Aluno aluno = dao.buscarPorId(id);
                    if (aluno != null) {
                        System.out.println(aluno);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("ID do aluno para atualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Aluno aluno = dao.buscarPorId(id);
                    if (aluno != null) {
                        System.out.print("Novo nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Nova idade: ");
                        int idade = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Novo curso: ");
                        String curso = sc.nextLine();

                        aluno.setNome(nome);
                        aluno.setIdade(idade);
                        aluno.setCurso(curso);

                        dao.atualizar(aluno);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("ID do aluno para deletar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    dao.deletar(id);
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
