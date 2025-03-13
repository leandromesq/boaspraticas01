import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

class Room {
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    private ArrayList<NPCs> npc;
    private ArrayList<Itens> itens;
    public int NumNpcI;
    public int NumNpc;
    public String NomeNpc;
    public String NomeNpcI;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court
     * yard".
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        npc = new ArrayList<NPCs>();
        itens = new ArrayList<Itens>();

    }

    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     * You are in the kitchen.
     * Exits: north west
     */
    public String getLongDescription() {
        Nnpcs();
        nomesNPCs();

        return barra() + "\n" + description + ".\n\n" + "NPCs na sala: " + NumNpc + ".\n" + NomeNpc + ".\n\n"
                + "Inimigos na sala: " + NumNpcI + "\n" + NomeNpcI + ".\n\n" + getExitString() + ".\n" + barra() + "\n";
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    private String getExitString() {
        String returnString = "Saídas:";
        Set<String> keys = exits.keySet();
        for (Iterator<String> iter = keys.iterator(); iter.hasNext();)
            returnString += " " + iter.next();
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(String direction) {
        return (Room) exits.get(direction);
    }

    public void addNPC(NPCs npcs) {
        npc.add(npcs);

    }

    public void addItem(Itens item) {
        itens.add(item);
    }

    public void Nnpcs() {
        this.NumNpcI = 0;
        this.NumNpc = 0;
        for (NPCs c : npc) {
            if (c instanceof NPCinimigo) {
                this.NumNpcI++;
            } else
                this.NumNpc++;
        }
    }

    public void nomesNPCs() {
        this.NomeNpc = "";
        this.NomeNpcI = "";
        for (NPCs c : npc) {
            if (c instanceof NPCinimigo) {
                this.NomeNpcI += c.getNome() + ", ";

            } else
                this.NomeNpc += c.getNome() + ", ";
        }
        if (NomeNpc.length() > 2) {

            NomeNpc = NomeNpc.substring(0, NomeNpc.length() - 2);
        }
        if (NomeNpcI.length() > 2) {
            NomeNpcI = NomeNpcI.substring(0, NomeNpcI.length() - 2);
        }
    }

    public NPCs getNpc(String nome) {
        NPCs i = null;
        for (NPCs c : npc) {
            if (c.getNome().equals(nome)) {
                i = c;
            }
        }
        return i;
    }

    public NPCs getNpcLoja() {
        for (NPCs c : npc) {
            if (c instanceof NPCloja) {
                return c;
            }
        }
        return null;
    }

    public String getNpcInimigo() {

        String npcs = "";

        for (NPCs c : npc) {
            if (c instanceof NPCinimigo) {

                npcs += c.getNome() + " ";

            }
        }
        return npcs;
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

    public void mudarDescricao(String descricao) {
        this.description = descricao;
    }

    public Itens roubarItem(String item) {
        Itens i = encontraItem(item);
        if (i != null) {
            return i;
        } else
            return null;

    }

    public String barra() {
        return "--------------------------------------------------------------------------------------------------------------------------------------------";
    }
}