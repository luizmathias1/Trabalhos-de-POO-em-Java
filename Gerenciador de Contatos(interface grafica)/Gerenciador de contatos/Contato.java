import java.io.Serializable;

public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String email;
    private int telefone;

    public Contato(String nome, String email, int telefone) throws GerenciadorDeContatosException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new GerenciadorDeContatosException.NomeVazioException();
        }
        if (String.valueOf(telefone).length() != 9) {
            throw new GerenciadorDeContatosException.TelefoneInvalidoException();
        }
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws GerenciadorDeContatosException.NomeVazioException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new GerenciadorDeContatosException.NomeVazioException();
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) throws GerenciadorDeContatosException.TelefoneInvalidoException {
        if (String.valueOf(telefone).length() != 9) {
            throw new GerenciadorDeContatosException.TelefoneInvalidoException();
        }
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
