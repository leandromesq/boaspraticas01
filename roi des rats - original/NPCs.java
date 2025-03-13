import java.util.ArrayList;
import java.io.IOException;
/*
@karabimbim karabimbim
 */
public abstract class NPCs
{
    protected String nome;
    protected String sala;
    protected String fala;

    protected ArrayList<Itens> itens;
    protected ArrayList<String> falas;
    protected String posicao;
    protected int falaIndex = 0;
    protected boolean dorme = false;
    public boolean roubado = false;

    public abstract String getNome();

    public abstract String getFala();

    public String getPosicao(){
        return this.posicao;
    }

    public abstract void addItem(Itens item);

    public void addIndexFala(int x){
        falaIndex += x;
    }
    public void deletaItem(String item){
        for(Itens c: itens){
            if(c.getNome().equals(item)){
                itens.remove(c);
            }
        }
    }

    public void printItem(){
        for(Itens c: itens){
            System.out.println(c.getNome() + " ");
        }
    }

    public Itens encontraItem(String item){
        Itens i = null;
        for(Itens c: itens){
            if(c.getNome().equals(item)){
                i = c;
            }
        }
        return i;
    }

    public abstract void steal(ArrayList<Itens> c);

    public void setRoubado(boolean roubado){
        this.roubado = roubado;
    }

    public Itens comprar(String item){
        Itens i = encontraItem(item);
        if(i != null){
            return i;
        }else return null;

    }

    public abstract String falar();

    public void dormir(){
        this.dorme = true;
        System.out.println(this.nome + ": ZZZZzzzzz.... \n"); 
    }
    public boolean getDorme(){
        return this.dorme;
    }
}