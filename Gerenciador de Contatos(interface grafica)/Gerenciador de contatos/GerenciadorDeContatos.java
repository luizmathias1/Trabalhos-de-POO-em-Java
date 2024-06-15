import java.io.*;
import java.util.*;

public class GerenciadorDeContatos {
    private List<Contato> contatos;
    private String arquivo;

    public GerenciadorDeContatos(String arquivo) {
        this.arquivo = arquivo;
        this.contatos = new ArrayList<>();
        carregarContatos();
    }

    public void adicionarContato(Contato contato) throws GerenciadorDeContatosException {
        if (contato.getNome() == null || contato.getNome().trim().isEmpty()) {
            throw new GerenciadorDeContatosException.NomeVazioException();
        }
        for (Contato c : contatos) {
            if (c.getTelefone() == contato.getTelefone()) {
                throw new GerenciadorDeContatosException.TelefoneJaCadastradoException(c.getNome());
            }
        }
        contatos.add(contato);
    }

    public Contato buscarContatoPorTelefone(int telefone) {
        for (Contato c : contatos) {
            if (c.getTelefone() == telefone) {
                return c;
            }
        }
        return null;
    }

    public void modificarContato(int telefone, String novoNome, String novoEmail, int novoTelefone) throws GerenciadorDeContatosException {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new GerenciadorDeContatosException.NomeVazioException();
        }
        Contato contato = buscarContatoPorTelefone(telefone);
        if (contato != null) {
            if (novoTelefone != telefone && buscarContatoPorTelefone(novoTelefone) != null) {
                throw new GerenciadorDeContatosException.TelefoneJaCadastradoException(buscarContatoPorTelefone(novoTelefone).getNome());
            }
            contato.setNome(novoNome);
            contato.setEmail(novoEmail);
            contato.setTelefone(novoTelefone);
        } else {
            throw new GerenciadorDeContatosException.ContatoNaoEncontradoException();
        }
    }

    public void removerContato(int telefone) throws GerenciadorDeContatosException {
        Contato contato = buscarContatoPorTelefone(telefone);
        if (contato != null) {
            contatos.remove(contato);
        } else {
            throw new GerenciadorDeContatosException.ContatoNaoEncontradoException();
        }
    }

    public List<Contato> listarContatos() {
        return contatos;
    }

    public void salvarContatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(contatos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarContatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            contatos = (List<Contato>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado, iniciando com lista vazia
            contatos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
