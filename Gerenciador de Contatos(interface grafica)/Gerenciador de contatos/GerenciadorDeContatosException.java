public class GerenciadorDeContatosException extends Exception {
    public GerenciadorDeContatosException(String message) {
        super(message);
    }

    public static class NomeVazioException extends GerenciadorDeContatosException {
        public NomeVazioException() {
            super("O nome do contato não pode ser vazio.");
        }
    }

    public static class TelefoneInvalidoException extends GerenciadorDeContatosException {
        public TelefoneInvalidoException() {
            super("O telefone deve ter exatamente 9 dígitos.");
        }
    }

    public static class TelefoneJaCadastradoException extends GerenciadorDeContatosException {
        public TelefoneJaCadastradoException(String nome) {
            super("Telefone já cadastrado: " + nome);
        }
    }

    public static class ContatoNaoEncontradoException extends GerenciadorDeContatosException {
        public ContatoNaoEncontradoException() {
            super("Contato não encontrado.");
        }
    }
}
