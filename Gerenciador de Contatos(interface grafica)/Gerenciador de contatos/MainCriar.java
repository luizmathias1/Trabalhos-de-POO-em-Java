import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCriar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeContatos gerenciadorDeContatos = new GerenciadorDeContatos("contatos.ser");

        while (true) {
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Salvar e sair");
            System.out.print("Escolha uma opção: ");

            try {
                int escolha = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o email: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite o telefone (9 dígitos): ");
                        int telefone = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha

                        try {
                            Contato novoContato = new Contato(nome, email, telefone);
                            gerenciadorDeContatos.adicionarContato(novoContato);
                        } catch (GerenciadorDeContatosException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 2:
                        gerenciadorDeContatos.listarContatos();
                        break;
                    case 3:
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
