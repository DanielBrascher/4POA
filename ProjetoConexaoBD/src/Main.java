import dao.UsuarioDAO;
import model.Usuario;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    Usuario novo = new Usuario(nome, email);
                    if (dao.inserir(novo)) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Falha ao cadastrar usuário.");
                    }
                    break;

                case 2:
                    List<Usuario> lista = dao.listar();
                    System.out.println("\n--- Usuários Cadastrados ---");
                    for (Usuario u : lista) {
                        System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail());
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
