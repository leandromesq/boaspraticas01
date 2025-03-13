
public class Itens
{

    private String nome;
    private int preco;

    public Itens(String nome,int preco )
    {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPreco(){
        return preco;
    }
}