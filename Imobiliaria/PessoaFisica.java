public class PessoaFisica {

    private String nome;

    private String telefone;

    public PessoaFisica(String nome, String telefone){

        this.nome = nome;

        this.telefone = telefone;
    }

    public void show(){
        System.out.println("nome: " + nome);

        System.out.println("Telefone: " + telefone);
    }

    public String nome(){

        return nome;
    }
}