import java.util.ArrayList;

public class Imobiliaria {

    private String nome;

    ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();

    public Imobiliaria(String nome){

        this.nome = nome;
    }

    public void adicionar_apartamento(Apartamento apartamento){
        this.apartamentos.add(apartamento);
    }

    public void show(){
        System.out.println("Imobiliaria " + nome);

        System.out.println("Apartamentos: ");
        for (Apartamento apartamento : apartamentos){
            apartamento.show();
        }
    }
}