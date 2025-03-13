import java.util.ArrayList;

public class NPCcomum extends NPCs {
    private ArrayList<Itens> itens;
    private ArrayList<String> falas;
    public boolean dorme = false;

    NPCcomum(String nome, String fala) {
        this.nome = nome;
        this.fala = fala;
        itens = new ArrayList<Itens>();
        falas = new ArrayList<String>();
        addFala(fala);

    }

    private void addFala(String fala) {
        falas.add(fala);
    }

    public String getNome() {
        return this.nome;
    }

    public String getFala() {
        return "Nome: " + this.nome + " Fala: " + this.fala;

    }

    public void addItem(Itens item) {
        itens.add(item);
    }

    public void printItem() {
        for (Itens c : itens) {
            System.out.println(c.getNome() + " ");
        }
    }

    public Itens encontraItem(String item) {
        Itens i = null;
        for (Itens c : itens) {
            if (c.getNome().equals(item)) {
                i = c;
            }
        }
        return i;
    }

    public void steal(ArrayList<Itens> c) {

        System.out.println("Itens roubados: \n");
        for (Itens i : itens) {
            c.add(i);
            System.out.println(i.getNome() + " ");
        }
        itens.clear();

    }

    public String falar() {

        if (falas.size() == 0) {
            return "...";
        }
        String f = this.nome + ": " + falas.get(0 + falaIndex);
        return f;
    }

}