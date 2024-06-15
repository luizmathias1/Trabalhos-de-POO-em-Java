import java.util.InputMismatchException;
import java.util.Scanner;

public class MainRecuperar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeContatos gerenciadorDeContatos = new GerenciadorDeContatos("contatos.ser");

        while (true) {
            System.out.println("1. Listar contatos");
            System.out.println("2. Modificar contato");
            System.out.println("3. Remover contato");
            System.out.println("4. Salvar e sair");
            System.out.print("Escolha uma opção: ");

            try {
                int escolha = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                switch (escolha) {
                    case 1:
                        gerenciadorDeContatos.listarContatos();
                        break;
                    case 2:
                        System.out.print("Digite o ID do contato que deseja modificar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha

                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Digite o novo email: ");
                        String novoEmail = scanner.nextLine();
                        System.out.print("Digite o novo telefone (9 dígitos): ");
                        int novoTelefone = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha

                        try {
                            gerenciadorDeContatos.modificarContato(id, novoNome, novoEmail, novoTelefone);
                        } catch (GerenciadorDeContatosException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Digite o ID do contato que deseja remover: ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha

                        try {
                            gerenciadorDeContatos.removerContato(idRemover);
                        } catch (GerenciadorDeContatosException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 4:
                        gerenciadorDeContatos.salvarContatos();
                        System.out.println("Contatos salvos. Saindo.");
                        return;
                    default:
                        throw new GerenciadorDeContatosException("Escolha inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();  // Consumir a linha inválida
            } catch (GerenciadorDeContatosException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
