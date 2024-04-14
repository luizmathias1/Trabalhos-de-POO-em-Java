public class Main {
    public static void main(String[] args){

        PessoaFisica Luiz = new PessoaFisica("Luiz Mathias", "41 98888-8888" );
        PessoaFisica Giovana = new PessoaFisica("Giovana", "41 99999-9999");

        Imobiliaria ImoveisLuiz = new Imobiliaria("LouisImoveis");

        Apartamento apartamento1 = new Apartamento(1, 45, 100);
        Apartamento apartamento2 = new Apartamento(2, 55, 100);

        apartamento1.fixar_preco(2000);
        apartamento1.fixar_proprietario(Luiz);


        apartamento2.fixar_proprietario(Giovana);
        apartamento2.fixar_preco(1000);

        ImoveisLuiz.adicionar_apartamento(apartamento1);
        ImoveisLuiz.adicionar_apartamento(apartamento2);

        ImoveisLuiz.show();

        Luiz.show();

        Giovana.show();
    }
}
