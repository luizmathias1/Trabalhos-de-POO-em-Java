import java.io.*;
import java.util.*;

public class LeituraDados {

    // Função para leitura e geração de contatos (Retorna uma lista contendo todos os contatos)
    public static List<Contato> gerarContatos(String nomeArquivo) {
        List<Contato> contatos = new ArrayList<>(); // Lista onde ficarão armazenados os objetos do tipo Contato

        try {
            // Realiza a leitura do arquivo
            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(arquivo);
            String linha;

            // Ignorar o cabeçalho
            br.readLine();

            // While roda a cada linha lida
            while ((linha = br.readLine()) != null) {
                // Joga os valores lidos separados por ; na lista valores
                String[] tokens = linha.split(";");
                List<String> valores = Arrays.asList(tokens);

                String telefoneStr = valores.get(2);

                // Converter telefone de String para int e gerar contatos com o método construtor
                try {
                    int telefone = Integer.parseInt(telefoneStr);
                    if (String.valueOf(telefone).length() != 9) {
                        System.err.println("O telefone deve ter exatamente 9 dígitos: " + telefone);
                        continue;
                    }
                    Contato contato = new Contato(valores.get(0), valores.get(1), telefone);
                    contatos.add(contato);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter telefone: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                } catch (GerenciadorDeContatosException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contatos;
    }

    public static void main(String[] args) {
        // Defina o caminho do arquivo CSV diretamente no código
        String caminhoArquivo = "C:\\Users\\luizm\\OneDrive - Grupo Marista\\3 SEMESTRE\\POO\\Trabalho RA03\\Trabalhos\\informacoes.csv";

        List<Contato> contatos = gerarContatos(caminhoArquivo);

        // Adiciona os contatos ao GerenciadorDeContatos
        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos("contatos.ser");
        for (Contato contato : contatos) {
            try {
                gerenciador.adicionarContato(contato);
            } catch (GerenciadorDeContatosException e) {
                System.err.println("Erro ao adicionar contato: " + e.getMessage());
            }
        }

        // Salva os contatos no arquivo
        gerenciador.salvarContatos();
        System.out.println("Contatos importados e salvos com sucesso.");

        // Exibe os contatos carregados
        List<Contato> contatosCarregados = gerenciador.listarContatos();
        for (Contato contato : contatosCarregados) {
            System.out.println(contato);
        }
    }
}
