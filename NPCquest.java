import java.util.ArrayList;

public class NPCquest extends NPCs
{
    private ArrayList<Itens> itens;
    private ArrayList<String> falas;

    NPCquest(String nome){
        this.nome = nome;
        itens = new ArrayList<Itens>();
        falas = new ArrayList<String>(){{
                add("Olá, você finalmente acordou, meu nome é Raul e eu tenho um trabalho importante pra você, uma missão que pode te colocar no topo de toda essa legião. Vá ao norte, busque para mim o cálice \nsagrado na catedral, depois volte aqui que te passarei mais instruções. E se eu fosse você eu comprava dardos soníferos, ou você não conseguirá passar por nenhum dos guardas");
                add("Você voltou! Bom trabalho com o cálice, agora preciso que você vá até o sul e busque o colar de ouro da família Bourbon para mim");
                add("Você foi rápido! Bom trabalho! Vá até o palácio ao leste e me traga a coroa do rei, eu sei, pode ser difícil, mas é com a liderança da legião que estamos trabalhando.");
                add("Muito bem, um último trabalho, vá ao museu, à oeste daqui, busque a pintura com a imagem de um roedor, sem perguntas.");
                add("Enfim você completou todas as tarefas fornecidas, aqui está sua recompensa, \numa chave com o peculiar formato de um rato, eu tenho certeza que ela deve abrir algum lugar por onde você já passou, boa sorte.");

            }};

    }

    public String getNome(){
        return this.nome;
    }

    public String getFala(){
        return "Nome: " + this.nome + " Fala: " + this.fala;

    }

    public void addItem(Itens item){
        itens.add(item);
    }

    public void addIndexFala(int x){
        falaIndex += x;
    }

    public void steal(ArrayList<Itens> c){
        System.out.println("Está realmente tentando me roubar? \n");

    }

    public String falar(){
        if(falas.size() == 0){
            return "...";
        }
        String f = this.nome + ": " + falas.get(0 + falaIndex);
        return f;
    }
}
