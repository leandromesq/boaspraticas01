import java.util.ArrayList;

public class NPCloja extends NPCs {
    private ArrayList<Itens> itens;
    private ArrayList<String> falas;

    NPCloja(String nome) {
        this.nome = nome;
        itens = new ArrayList<Itens>();
        falas = new ArrayList<String>() {
            {
                add("Bem vindo  minha loja, eu sou Remi, o rato, o que voc est procurando hoje?");
            }
        };

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
        System.out.println("ITENS  VENDA: ");
        for (Itens c : itens) {
            System.out.println(c.getNome() + " - $" + c.getPreco());
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

    public void deletaItem(String item) {
        for (Itens c : itens) {
            if (c.getNome().equals(item)) {
                itens.remove(c);
            }
        }
    }

    public void steal(ArrayList<Itens> c) {
        System.out.println("O que voc acha que est fazendo? No tente me roubar, mais respeito ao rato!. \n");
    }

    public Itens comprar(String item) {
        Itens i = encontraItem(item);
        if (i != null) {
            return i;
        } else
            return null;

    }

    public String falar() {
        if (falas.size() == 0) {
            return "...";
        }
        String f = this.nome + ": " + falas.get(0 + falaIndex);
        return f;
    }
}
