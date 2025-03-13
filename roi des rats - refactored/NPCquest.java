import java.util.ArrayList;

public class NPCquest extends NPCs {
    private ArrayList<Itens> itens;
    private ArrayList<String> falas;

    NPCquest(String nome) {
        this.nome = nome;
        itens = new ArrayList<Itens>();
        falas = new ArrayList<String>() {
            {
                add("Ol, voc finalmente acordou, meu nome  Raul e eu tenho um trabalho importante pra voc, uma misso que pode te colocar no topo de toda essa legio. V ao norte, busque para mim o clice \nsagrado na catedral, depois volte aqui que te passarei mais instrues. E se eu fosse voc eu comprava dardos sonferos, ou voc no conseguir passar por nenhum dos guardas");
                add("Voc voltou! Bom trabalho com o clice, agora preciso que voc v at o sul e busque o colar de ouro da famlia Bourbon para mim");
                add("Voc foi rpido! Bom trabalho! V at o palcio ao leste e me traga a coroa do rei, eu sei, pode ser difcil, mas  com a liderana da legio que estamos trabalhando.");
                add("Muito bem, um ltimo trabalho, v ao museu,  oeste daqui, busque a pintura com a imagem de um roedor, sem perguntas.");
                add("Enfim voc completou todas as tarefas fornecidas, aqui est sua recompensa, \numa chave com o peculiar formato de um rato, eu tenho certeza que ela deve abrir algum lugar por onde voc j passou, boa sorte.");

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

    public void addIndexFala(int x) {
        falaIndex += x;
    }

    public void steal(ArrayList<Itens> c) {
        System.out.println("Est realmente tentando me roubar? \n");

    }

    public String falar() {
        if (falas.size() == 0) {
            return "...";
        }
        String f = this.nome + ": " + falas.get(0 + falaIndex);
        return f;
    }
}
