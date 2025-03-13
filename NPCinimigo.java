import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Runtime;
public class NPCinimigo extends NPCs
{
    private ArrayList<Itens> itens;
    private ArrayList<String> falas;
    

    NPCinimigo(String nome, String posicao){
        this.nome = nome;
        this.posicao = posicao;
        itens = new ArrayList<Itens>();
        falas = new ArrayList<String>();

    }

    public String getNome(){
        return this.nome;
    }

    public String getPosicao(){
        return this.posicao;
    }

    public String getFala(){
        return "Nome: " + this.nome + " Fala: " + this.fala;

    }

    public void addItem(Itens item){
        itens.add(item);
    }

    public void printItem(){
        for(Itens c: itens){
            System.out.println(c.getNome() + " ");
        }
    }

    public Itens econtraItem(String item){
        Itens i = null;
        for(Itens c: itens){
            if(c.getNome().equals(item)){
                i = c;
            }
        }
        return i;
    }

    public void steal(ArrayList<Itens> c){

        System.out.println("Itens roubados: \n");
        for(Itens i: itens){
            c.add(i);
            System.out.println(i.getNome() + " ");
        }
        itens.clear();

    }

    public void setRoubado(boolean roubado){
        this.roubado = roubado;
    }

    public String falar(){
        if(falas.size() == 0){ 
             return "Melhor não falar com nenhum guarda... eles podem suspeitar. ";

        }
        String f = this.nome + ": " + falas.get(0 + falaIndex);
        return f;
    }

    public void dormir(){
        this.dorme = true;
        System.out.println(this.nome + ": ZZZZzzzzz.... \n"); 
    }

    public boolean getDorme(){
        return this.dorme;
    }
}
