import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;

class Game 
{
    boolean wantToQuit;
    File dardoSom = new File("./sons/dardo.WAV");
    File portaSom = new File("./sons/porta.WAV");
    File roubarSom = new File("./sons/roubo.WAV");
    File bombaSom = new File("./sons/bomba.WAV");
    File tiroSom = new File("./sons/shot.WAV");
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Itens> itensP;
    private int gold;
    private int dardos;
    private int minGoldPorRoubo;
    private int maxGoldPorRoubo;
    Random goldRandom = new Random();
    int randomNumber;
    
    //guardas:
    NPCinimigo guardaN1, guardaN2, guardaN3,

    guardaS1,

    guardaL1, guardaL2, guardaL3, guardaL4,

    guardaO1, guardaO2;
    //loja:
    NPCloja remi;
    //quest:
    NPCquest raul;
    //npcscomuns:
    NPCcomum padre_auguste, padre_william, padre_cloridan, padre_andre, padre_ernesti,
    mercador_nicolas, mercador_pierre, mercador_sebastian, artista_biscuit, jornaleiro,
    musico_charlote, mimico, 

    baltazar,

    orville, tyson, astolpho, gregoire, oliver, ignace, timothee, joanna, patricia, david, verrill, aleron, germaine, dreux, sidney, philippe;
    //itens:
    Itens dardo, ima, disfarce, informacao, chave_catedral, calice,
    colar,
    coroa,
    fumaca, pintura,
    chave_rato;
    //salas:
    Room main,
    en1, en2, en3, en4, en5, en6, cn1, cn2, cn3, cn4, cn5, cn6, 
    es1, es2, es3, es4, es5, es6, cs1, cs2, cs3, cs4, cs5, cs6, 
    el1, el2, el3, el4, el5, el6, cl1, cl2, cl3, cl4, cl5, f1, f2, f3,
    eo1, eo2, eo3, eo4, eo5, eo6, co1, co2, co3, co4, co5, co6;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        itensP = new ArrayList<Itens>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {

        orville =  new NPCcomum("Orville", "O tempo aqui em baixo � sempre o mesmo, n�o � como se fosse f�cil criar conversas passageiras.");
        tyson = new NPCcomum("Tyson", "Ser� que eu sou o �nico que n�o suporta mais esse cheiro podre? Esse lugar podia ter uma limpeza�");
        astolpho = new NPCcomum("Astolpho", "Voc� � um daqueles ladr�es que se acham roedores?");
        gregoire = new NPCcomum("Gregoire", "Esse rato que espreita nas paredes dos esgotos me assusta, ele est� em todos os lugares ao mesmo tempo.");
        oliver = new NPCcomum("Oliver", "Voc� gostaria de uma ta�a de vinho? Eu queria ter uma pra poder oferecer.");
        ignace = new NPCcomum("Ignace", "Existem dois tipos de pessoas que eu n�o confio: m�micos e artistas.");
        timothee = new NPCcomum("Timothee", "Eu n�o gosto do escuro, tenho muito medo, por isso mesmo que eu n�o saio daqui de jeito nenhum.");
        joanna = new NPCcomum("Joanna", "Voc� j� foi at� a superf�cie? Sempre quis saber como � l� em cima.");
        patricia = new NPCcomum("Patricia", "A melhor parte de morar nos esgotos � n�o ter que se preocupar com a pr�pria higiene. Mas tamb�m deve ser por isso que eu fico t�o doente.");
        david = new NPCcomum("David", "N�o estou no clima para conversa fiada.");
        verrill = new NPCcomum("Verrill", "As pessoas na superf�cie procuram formas em nuvens, eu procuro formas no lodo que forma nas paredes.");
        aleron = new NPCcomum("Aleron", "De vez em quando eu acho algumas coisas legais pelo esgoto, foi aqui que eu encontrei esse capuz.");
        germaine = new NPCcomum("Germaine", "Eu juro por tudo que eu sou um general da guarda real, mas aqueles guardas n�o acreditam em mim!");
        dreux = new NPCcomum("Dreux", "Vivendo no esgoto eu aprendi que as melhores coisas da vida, provavelmente n�o est�o em um esgoto");
        sidney = new NPCcomum("Sidney", "Eu lutarei pela minha honra, pela honra de minha fam�lia, e pela honra da legi�o.");
        philippe = new NPCcomum("Philippe", "Eu estava escondido, hehehehe"); 

        padre_auguste = new NPCcomum("Auguste", "... Que a paz do senhor esteja convosco neste per�odo de trevas�");
        padre_william = new NPCcomum("William", "O que aflige sua alma turbulenta?");
        padre_cloridan = new NPCcomum("Cloridan", "... *cof cof*... paz de Cristo");
        padre_andre = new NPCcomum("Andre", "O que aflige sua alma turbulenta?");
        padre_ernesti = new NPCcomum("Ernesti", "O que aflige sua alma turbulenta?");
        mercador_nicolas = new NPCcomum("Nicolas", "Bem vindo � minha loja, algo espec�fico que o senhor est� a procura?");
        mercador_pierre = new NPCcomum("Pierre", "Bem vindo � loja de Pierre. Eu sou Pierre, e esta � a minha loja, v� algo que te interessa? \nAh voc� est� atr�s desse colar de ouro velho? 90 moedas!");
        mercador_sebastian = new NPCcomum("Sebastian", "Seja muito bem vindo � minha loja, como posso lhe ajudar?");
        artista_biscuit = new NPCcomum("Biscuit", "N�o interrompa o processo criativo de um artista!");
        jornaleiro = new NPCcomum("Jornaleiro", "Extra, Extra! Protestos ao redor da cidade ocorrem em oposi��o � monarquia! \nExtra, Extra! Novos boatos confirmam uma s�rie de roubos ocorrendo em pontos importantes da cidade!");
        musico_charlote = new NPCcomum("Charlote", "Se o senhor pudesse me dar 5 minutos do seu tempo para ouvir uma de minhas can��es eu prometo que n�o ir� se arrepender, al�m disso qualquer ajuda � bem vinda");
        mimico = new NPCcomum("Mimico", "...  *Gestos*  *Gestos*  *:)*");

        baltazar = new NPCcomum("Baltazar", "Enfim nos encontramos pequeno roedor, voc� acha que pode tomar a lideran�a de mim, sim, a mesma pessoa que comanda a cidade, \ntamb�m comanda o subterr�neo dela, surpresa! Obrigado pelos itens que voc� me trouxe, mas infelizmente essa ser� a �ltima vez que nos falaremos.");
        guardaN1 = new NPCinimigo("guarda1norte", "norte");
        guardaN2 = new NPCinimigo("guarda2norte", "item");
        guardaN3 = new NPCinimigo("guarda3norte", "item");

        guardaS1 = new NPCinimigo("guarda1sul",  "sul");

        guardaL1 = new NPCinimigo("guarda1leste", "leste");
        guardaL2 = new NPCinimigo("guarda2leste", "norte");
        guardaL3 = new NPCinimigo("guarda3leste", "oeste");
        guardaL4 = new NPCinimigo("guarda4leste", "oeste");

        guardaO1 = new NPCinimigo("guarda1oeste", "norte");
        guardaO2 = new NPCinimigo("guarda2oeste", "item");

        raul = new NPCquest("Raul");
        remi = new NPCloja("Remi");

        //---sala principal:
        main = new Room("Voc� est� no subterr�neo da cidade, uma luz espreita da boca do bueiro acima de sua cabe�a. Al�m da luz da superf�cie, velas e tochas \niluminam o lugar, existem sa�das para os quatro lados nos t�neis dos esgotos, mas nenhuma sa�da para a superf�cie. ");
        //---salas do norte:
        en1 = new Room("Voc� se encontra na dire��o norte nos caminhos subterr�neos, o ambiente � escuro, iluminado apenas por algumas tochas, o cheiro, \napesar de forte, j� criou costume. O som de passos e chiados nas sombras ecoam pelos t�neis. ");
        en2 = new Room("Os t�neis, por onde transitam os membros da sociedade, s�o largos e �gua \nrasa cobrindo apenas a sola de seu sapato corre por eles. ");
        en3 = new Room("Sua voz ecoa nos t�neis escuros dos esgotos da cidade, junto � sua voz \nvoc� ouve um chiado baixo que vem da sua direita. ");
        en4 = new Room("Essa parte do t�nel possui sa�das para as quatro dire��es, a sa�da ao leste � na verdade um buraco na parede, de um tamanho um pouco menor \nque o de uma pessoa normal, os chiados que voc� ouvia por todo o caminho vinham dessa dire��o. O buraco emana um cheiro forte de� queijo? ");
        en5 = new Room("Passar pelo buraco na parede leva voc� a uma sala com decora��es em madeira e queijo por todo lado, no centro, uma bancada de madeira \ncoberta por um pano e diversos itens em cima. De tr�s da mesa surge um rato gigante, pouco menor que uma pessoa normal, em p� sobre as duas patas traseiras, o rato utiliza vestes de pano e couro, e usa um chap�u de general que voc� s� pode presumir que seja roubado. As coisas em cima da mesa parecem estar � venda. ");
        en6 = new Room("Voc� est� onde parece ser o fim da linha subterr�nea norte, uma escada se encontra no meio da sala que leva para a superf�cie onde \numa leve luz invade o ambiente. O barulho intenso de passos te traz a impress�o de que h� um grande fluxo de pessoas naquele local ");
        //salas da cidade do norte:
        cn1 = new Room("Voc� est� na superf�cie, em frente a catedral local, uma igreja de tamanho consider�vel, cheia de vitrais e ornamentos nos arredores, \numa grande porta de madeira marca a entrada do local, est� acontecendo uma missa l� dentro nesse momento, ao mesmo tempo em que protestos acontecem do lado de fora. ");
        cn2 = new Room("Voc� est� no sal�o principal da igreja, o som de �rg�os estabelecem um clima de melancolia e tristeza na catedral. O sacerdote \nrecita as palavras de sua missa enquanto dezenas de pessoas ajoelham-se nos genuflex�rios do sal�o, com as cabe�as baixas pesadas de culpa .");
        cn3 = new Room("Voc� se encontra na sala de confiss�es, uma sala silenciosa onde apenas os sons do sal�o principal invadem levemente. A sala possui \ndiversas cabines, cada uma presumidamente com um cl�rigo dentro, para ouvir as confiss�es de almas perdidas. ");
        cn4 = new Room("Voc� se encontra na parte mais � frente do sal�o principal, pr�ximo ao altar. Ao fundo voc� v� o �rg�o sendo tocado, al�m dos ornamentos \nem m�rmore e ouro que enfeitam a igreja. � oeste de sua dire��o fica a sala de confiss�es, enquanto � leste fica a sacristia, no caminho que leva ao cofre da igreja. ");
        cn5 = new Room("Voc� est� na sacristia, onde guardam as vestes e objetos usados na missa. A sua frente, no fundo da sala, � poss�vel \nver uma porta que leva ao dep�sito, ou cofre da igreja. A porta, por�m, est� trancada, e voc� ouve sons de guardas de dentro da sala. >>� NECESS�RIO >USAR< UMA CHAVE<< ");
        cn6 = new Room("Voc� entra nos dep�sitos da igreja, tesouros antigos, livros e objetos sagrados, em sua grande parte feitos ou banhados a ouro \nest�o por toda parte. Existem dois guardas no interior da sala, o (>>calice<<) - 'roubar' que voc� est� a procura se encontra no centro da sala. ");
        //---salas do sul:
        es1 = new Room("Voc� se encontra na dire��o sul dos esgotos. O ambiente composto de largos t�neis, iluminado por tochas, e com uma corrente fina \nde �gua passando em seus p�s d�o a sensa��o de isolamento que um esgoto normalmente traria, mas ao mesmo tempo voc� sente que est�o a te observar. ");
        es2 = new Room("Avan�ando pelos caminhos subterr�neos voc� encontra um buraco na parede, um pouco menor que um adulto m�dio, o buraco desvia do caminho \npor onde os t�neis do esgoto seguem, e exala um cheiro completamente diferente do que aquele ambiente normalmente tem. ");
        es3 = new Room("Passar pelo buraco na parede leva voc� a uma sala com decora��es em madeira e queijo por todo lado, no centro, uma bancada de madeira \ncoberta por um pano e diversos itens em cima. De tr�s da mesa surge um rato gigante, pouco menor que uma pessoa normal, em p� sobre as duas patas traseiras, o rato utiliza vestes de pano e couro, e usa um chap�u de general que voc� s� pode presumir que seja roubado. As coisas em cima da mesa parecem estar � venda. ");
        es4 = new Room("Sua voz ecoa por entre os t�neis desse setor do esgoto, dando a impress�o \nde que ela est� saindo por um lado e chegando pelo outro. ");
        es5 = new Room("Mais uma bifurca��o nos caminhos subterr�neos de Montpellier. O ambiente mal iluminado \ntamb�m n�o ajuda a remediar essa sensa��o de perdido que voc� sente naquele lugar. ");
        es6 = new Room("Voc� se encontra em uma sala com mais ilumina��o, a ilumina��o vem da superf�cie, de onde voc� tamb�m ouve o som de passos e pessoas \nconversando. Logo acima de sua cabe�a est� a esplanada Charles de Gaulle, uma pra�a importante da cidade. Escadas � sua frente levam at� a superf�cie. ");
        //salas da cidade do sul:
        cs1 = new Room("Voc� est� nas ruas da cidade, mais especificamente em frente � uma pra�a p�blica, est� ocorrendo uma feira de mercantes ao redor \ndessa pra�a circular. Algum desses comerciantes deve ter algo de valor. ");
        cs2 = new Room("Em meio �s �rvores, de frente a uma fonte no centro da pra�a, pessoas conversam e fazem suas trocas de mercadorias. Cada mercador \nparece ser de uma diferente regi�o, alguns aparentam at� mesmo n�o ser da Fran�a. ");
        cs3 = new Room("Em um canto mais ensolarado, alguns jornaleiros anunciam as not�cias locais, os protestos ao redor da cidade est�o cada vez mais \nfrequentes e cada vez mais violentos. Dizem que at� mesmo o pr�prio rei teme essa revolta popular. ");
        cs4 = new Room("Na parte mais externa da pra�a, algumas barracas maiores de mercadores est�o \nmontadas, entre elas, a que lhe foi informada que cont�m o colar que voc� procura. ");
        cs5 = new Room("Em meio �s pessoas, um artista se senta em um banco com um cavalete em sua frente, \ne realiza pintura das pessoas em frente � est�tua no centro da pra�a. ");
        cs6 = new Room("A pra�a � bem iluminada, o dia est� claro e bem movimentado. O ambiente � rodeado \nde �rvores, e possui uma est�tua hist�rica no centro. A pra�a � antiga, t�o antiga quanto a pr�pria cidade de Montpellier. ");
        //---salas do leste:
        el1 = new Room("Voc� se encontra no setor leste no subterr�neo por onde a sociedade dos ratos transita. O caminho a sua frente � um largo t�nel \nde tal extens�o a fazer com que voc� n�o consiga ver se tem realmente um fim. ");
        el2 = new Room("Seguindo o caminho desse longo t�nel, as paredes gastas e as teias de aranha assim como ratos ocasionalmente aparecem, mas � dif�cil \nse atentar a muitos detalhes com a pouca ilumina��o que o ambiente oferece ");
        el3 = new Room("Pr�ximo ao que parece ser o fim do t�nel leste, existe uma bifurca��o que leva ao norte, mas que claramente n�o � um caminho que originalmente \nestava l�, visto que a �gua n�o corre para aquele lado e a ilumina��o � quase nula na se��o seguinte. ");
        el4 = new Room("Voc� se encontra na se��o final do setor leste dos esgotos, assim como nos outros setores, \numa escada no centro da sala leva � superf�cie. A cidade naquele local parece estar silenciosa. ");
        el5 = new Room("Voc� est� numa parte extremamente mal iluminada dos t�neis, por onde voc� pisa voc� ouve barulho de coisas se mexendo, como se voc� estivesse \npisando em uma pilha de moedas. A �nica ilumina��o vem de um buraco na parede com um estranho cheiro de queijo. ");
        el6 = new Room("Passar pelo buraco na parede leva voc� a uma sala com decora��es em madeira e queijo por todo lado, no centro, uma bancada de madeira coberta por \num pano e diversos itens em cima. De tr�s da mesa surge um rato gigante, pouco menor que uma pessoa normal, em p� sobre as duas patas traseiras, o rato utiliza vestes de pano e couro, e usa um chap�u de general que voc� s� pode presumir que seja roubado. As coisas em cima da mesa parecem estar � venda. ");
        f1 = new Room("Voc� est� dentro dos corredores principais do pal�cio ap�s abrir a porta do cadeado de rato. Tudo aquilo parece um pouco confuso. Os corredores do \npal�cio, brancos com toques de ouro, parecem se estender cada vez mais � medida que voc� avan�a.");
        f2 = new Room("O tapete vermelho dos corredores do castelo te guiam at� onde parece ser a sala do trono. O sil�ncio daquele lugar � perturbador, voc� sente como se \nestivesse sido vigiado, e que, de qualquer modo, aquele seria o fim de sua jornada na legi�o dos ratos.");
        f3 = new Room("Voc� est� na sala do trono. O rei se senta no trono ao fim da sala, ele usa um tapa olho e carrega uma espada embainhada. A sala por incr�vel que \npare�a � mais simples do que o restante do pal�cio. Todos os objetos que voc� roubou durante esses �ltimos dias est�o ali, assim como os itens coletados de outros membros da legi�o.");
        //salas da cidade do leste:
        cl1 = new Room("Voc� est� na superf�cie da cidade, de frente a uma das torres do pal�cio real, A torre � \nalta e feita inteira de pedra, a entrada est� sendo vigiada por um guarda, o sil�ncio reina naquele local. ");
        cl2 = new Room("Voc� est� na base da torre do pal�cio, uma escada espiral leva at� o topo, as paredes n�o \ns�o muito largas, menores que os t�neis do esgoto, por�m melhor iluminadas. ");
        cl3 = new Room("Voc� se encontra no topo das escadarias do pal�cio, voc� est� na ala norte do castelo. A �nica sa�da se d� ao sul, em dire��o ao centro do pal�cio. \nO pal�cio � bem decorado, ornamentado com velas e detalhes em ouro, o lugar cheira como rosas, algo diferente para quem passou tanto tempo nos esgotos. ");
        cl4 = new Room("A sala ao leste est� com a porta aberta, e voc� pode ver alguns tesouros de dentro daquela sala, tudo aquilo soa estranho, o castelo parece muito \nvazio para um dia comum, talvez seja tudo reflexo do mutir�o de pessoas pela cidade. O caminho para o sul, em dire��o ao sagu�o principal do castelo assim como a sala do rei, est� trancado por uma porta com um cadeado de formato MUITO peculiar. O s�mbolo de um roedor???.");
        cl5 = new Room("Voc� est� na sala dos tesouros reais, ouro, joias, e objetos de valor, est�o todos nessa sala, \nestranho essa sala estar aberta sem nenhum tipo de guarda, de qualquer maneira, seu objetivo est� � sua frente.  A (>>coroa<<) - roubar real");
        //---salas do oeste:
        eo1 = new Room("Voc� se encontra no setor oeste dos esgotos de transporte da legi�o, ele n�o � otimizado para \ntransporte, s�o apenas t�neis de esgoto comuns, por�m a legi�o garante que ningu�m sem permiss�o passe por aqueles t�neis. ");
        eo2 = new Room("Passar pelo buraco na parede leva voc� a uma sala com decora��es em madeira e queijo por todo lado, no centro, uma bancada de madeira coberta por um \npano e diversos itens em cima. De tr�s da mesa surge um rato gigante, pouco menor que uma pessoa normal, em p� sobre as duas patas traseiras, o rato utiliza vestes de pano e couro, e usa um chap�u de general que voc� s� pode presumir que seja roubado. As coisas em cima da mesa parecem estar � venda. ");
        eo3 = new Room("Ao sul de sua dire��o h� um buraco na parede de onde vem um soar de um violino desafinado. \nNorte e Oeste formam uma bifurca��o sem nenhuma indica��o de onde vai cada um dos caminhos, talvez a legi�o devesse mapear melhor esses esgotos. ");
        eo4 = new Room("A esse ponto o cheiro dos esgotos j� n�o o incomoda mais, e a �gua rasa que corre na sola de \nseus p�s � s� mais um detalhe para completar esse cen�rio sujo de ladr�es. Uma luz vem da sala � sua frente. ");
        eo5 = new Room("Voc� se encontra em mais uma parte mal iluminada por meio de tochas e paredes ecoantes em \nmeio a tantas nesses esgotos. O som leve de m�sica ecoa at� os seus ouvidos, vindo do norte de sua dire��o. ");
        eo6 = new Room("Uma escada no centro da sala em que voc� est� leva at� a superf�cie. Onde pela m�sica que \nvoc� ouve te leva a crer que l� em cima � o museu de artes local. ");
        //salas da cidade do oeste:
        co1 = new Room("Voc� se encontra diretamente nas portas do museu de arte local, est� tendo uma exposi��o naquele momento, mas n�o muito movimentada, os interesses da \npopula��o naquele momento n�o s�o voltados para a arte, apesar da arte estar interessada na popula��o. ");
        co2 = new Room("Voc� est� em uma das salas do museu. Obras de arte ficam penduradas nas paredes, \nesculturas ao centro das salas, e algumas pessoas param de obra em obra para apreciar seu valor. Por�m essa sala n�o possui a obra que voc� procura. ");
        co3 = new Room("Voc� est� em uma das salas do museu, em um dos cantos do local, v�rias pessoas se re�nem ao redor de uma escultura, que voc� n�o consegue muito bem \nentender o motivo, provavelmente � a obra de algum artista famoso, por�m n�o � a obra que voc� procura. ");
        co4 = new Room("Voc� est� em uma das salas, em um dos cantos do museu. Aquele local est� completamente \nvazio, nenhuma obra e nenhuma pessoa, a n�o ser por um m�mico, que faz cr�ticas sociais ao rei por meio de gestos. ");
        co5 = new Room("Voc� est� em uma das salas do museu. A obra que voc� procura est� logo a sua frente, \npor�m h� muitas pessoas em volta dela... voc� precisa usar algo para distra�-las. ");
        co6 = new Room("Voc� est� em uma das salas do museu. Logo ao lado da entrada, um homem toca um violino em troca de trocados naquele lugar, mas ele n�o parece estar \nindo muito bem, pois o chap�u nele ao ch�o cont�m apenas algumas moedas, e a exposi��o j� se aproxima de suas �ltimas horas. ");

        //conectar salas do norte:
        en1.setExit("sul", main); en1.setExit("norte", en3); en1.setExit("leste", en2); en2.setExit("oeste", en1); en2.setExit("norte", en4); en3.setExit("sul", en1); en3.setExit("leste", en4); en4.setExit("oeste", en3); en4.setExit("sul", en2); en4.setExit("leste", en5); en4.setExit("norte", en6); en5.setExit("oeste", en4); en6.setExit("norte", cn1); en6.setExit("sul", en4); cn1.setExit("norte", cn2); cn2.setExit("norte", cn4); cn3.setExit("leste", cn4); cn4.setExit("sul", cn2); cn4.setExit("leste", cn5); cn4.setExit("oeste", cn3); cn5.setExit("oeste", cn4); cn6.setExit("sul", cn5);
        //conectar salas do sul:
        es1.setExit("norte", main); es1.setExit("sul", es4); es1.setExit("leste", es2); es2.setExit("oeste", es1); es2.setExit("leste", es3); es2.setExit("sul", es5); es3.setExit("oeste", es2); es4.setExit("norte", es1); es4.setExit("leste", es5); es5.setExit("oeste", es4); es5.setExit("norte", es2); es5.setExit("leste", es6); es6.setExit("oeste", es5); es6.setExit("sul", cs1); cs1.setExit("norte", es6); cs1.setExit("oeste", cs6); cs1.setExit("leste", cs2); cs2.setExit("oeste", cs1); cs2.setExit("sul", cs3); cs3.setExit("oeste", cs4); cs3.setExit("norte", cs2); cs4.setExit("oeste", cs5); cs4.setExit("leste", cs3); cs5.setExit("norte", cs6); cs5.setExit("leste", cs4); cs6.setExit("sul", cs5); cs6.setExit("leste", cs1);
        //conectar salas do leste:
        el1.setExit("oeste", main); el1.setExit("leste", el2); el2.setExit("oeste", el1); el2.setExit("leste", el3); el3.setExit("oeste", el2); el3.setExit("norte", el5); el3.setExit("leste", el4); el4.setExit("oeste", el3); el4.setExit("leste", cl1); el5.setExit("sul", el3); el5.setExit("norte", el6); el6.setExit("sul", el5); cl1.setExit("oeste", el4); cl1.setExit("norte", cl2); cl2.setExit("sul", cl1); cl2.setExit("leste", cl3); cl3.setExit("oeste", cl2); cl3.setExit("sul", cl4); cl4.setExit("norte", cl3); cl4.setExit("oeste", cl5); cl5.setExit("leste", cl4); f1.setExit("norte", cl4); f1.setExit("sul", f2); f2.setExit("norte", f1); f2.setExit("sul", f3);
        //conectar salas do oeste:
        eo1.setExit("leste", main); eo1.setExit("oeste", eo3); eo2.setExit("norte", eo3); eo3.setExit("leste", eo1); eo3.setExit("sul", eo2); eo3.setExit("norte", eo4); eo3.setExit("oeste", eo5); eo4.setExit("sul", eo3); eo4.setExit("oeste", eo6); eo5.setExit("leste", eo3); eo5.setExit("norte", eo6); eo6.setExit("sul", eo5); eo6.setExit("leste", eo4); eo6.setExit("norte", co1); co1.setExit("sul", eo6); co1.setExit("oeste", co6); co1.setExit("norte", co2); co2.setExit("sul", co1); co2.setExit("oeste", co5); co2.setExit("norte", co3); co3.setExit("sul", co2); co3.setExit("oeste", co4); co4.setExit("leste", co3); co4.setExit("sul", co5); co5.setExit("norte", co4); co5.setExit("leste", co2); co5.setExit("sul", co6); co6.setExit("norte", co5); co6.setExit("leste", co1);

        main.setExit("norte", en1);

        dardo = new Itens("dardo", 5);
        ima = new Itens("im�", 15);
        disfarce = new Itens("disfarce", 100);
        informacao = new Itens("informacao", 5);
        chave_catedral = new Itens("chave", 0);
        calice = new Itens("calice", 0);
        colar = new Itens("colar valioso", 0);
        coroa = new Itens("coroa", 0);
        fumaca = new Itens("fumaca", 0);
        pintura = new Itens("pintura valiosa", 0);
        chave_rato = new Itens("chave-rato", 0);
        //adicionar npcs as salas:

        //NPCs "lixos":
        en1.addNPC(orville);
        en2.addNPC(tyson);
        en3.addNPC(astolpho);
        en4.addNPC(gregoire);

        es1.addNPC(oliver);
        es2.addNPC(ignace);
        es4.addNPC(timothee);
        es5.addNPC(joanna);

        el1.addNPC(patricia);
        el2.addNPC(david);
        el3.addNPC(verrill);
        el5.addNPC(aleron);

        eo1.addNPC(germaine);
        eo3.addNPC(dreux);
        eo4.addNPC(sidney);
        eo5.addNPC(philippe);

        //inimigos:
        en6.addNPC(guardaN1);
        cn6.addNPC(guardaN2);
        cn6.addNPC(guardaN3);

        es6.addNPC(guardaS1);

        el4.addNPC(guardaL1);
        cl1.addNPC(guardaL2);
        cl4.addNPC(guardaL3);
        cl4.addNPC(guardaL4);
        f3.addNPC(baltazar);

        eo6.addNPC(guardaO1);
        co5.addNPC(guardaO2);

        //sala main:

        main.addNPC(raul);

        //NPCs da cidade:
        cn4.addNPC(padre_auguste);
        cn3.addNPC(padre_william);
        cn3.addNPC(padre_cloridan);
        cn3.addNPC(padre_andre);
        cn3.addNPC(padre_ernesti);

        cs3.addNPC(jornaleiro);
        cs4.addNPC(mercador_nicolas);
        cs4.addNPC(mercador_pierre);
        cs4.addNPC(mercador_sebastian);
        cs5.addNPC(artista_biscuit);

        co6.addNPC(musico_charlote);
        co4.addNPC(mimico);

        //NPCs de loja:
        eo2.addNPC(remi);
        el6.addNPC(remi);
        es3.addNPC(remi);
        en5.addNPC(remi);

        //adicionando itens de quest em personagens:
        padre_cloridan.addItem(chave_catedral);
        mercador_pierre.addItem(colar);
        mimico.addItem(fumaca);

        //adicionando itens na sala:
        cn6.addItem(calice);
        cl5.addItem(coroa);

        //adicionando itens da loja:
        remi.addItem(dardo);
        remi.addItem(disfarce);
        remi.addItem(informacao);
        remi.addItem(ima);

        currentRoom = main;  // come�ar o game no main
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        this.gold = 5;
        this.dardos = 0;
        this.minGoldPorRoubo = 2;
        this.maxGoldPorRoubo = 7;
        printWelcome();

        

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar! Tchau!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("                                                                       ()-() ");  
        System.out.println("------------------------------------------------------------------------\\" +" /------------------------------------------------------------------------");
        System.out.println("                                                                         `   ");
        System.out.println("Bem vindo a Roi des Rats.");
        System.out.println("Roi des Rats � um jogo em que voc� � um ladr�o parte de uma sociedade secreta que opera no subterr�neo de uma cidade francesa.");
        System.out.println("Digite 'ajuda' se voc� precisar de ajuda.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        NPCs r = currentRoom.getNpc("Raul");
        System.out.println(r.falar());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("N�o entendi o que voc� quis dizer...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("ajuda"))
            printHelp();
        else if (commandWord.equals("ir"))
            goRoom(command);
        else if (commandWord.equals("sair")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("olhar")) {
            System.out.println(currentRoom.getLongDescription());
        }
        else if (commandWord.equals("roubar")) {
            steal(command);
        }
        else if (commandWord.equals("comprar")) {
            comprar(command);
        }
        else if (commandWord.equals("falar")) {
            falar(command);
        }
        else if (commandWord.equals("inventario")){
            mostraInventario();
        }
        else if (commandWord.equals("dardo")){
            dardo(command);
        }
        else if (commandWord.equals("usar")){
            usar(command);
        }
        else if (commandWord.equals("informacao")){
            informacao();
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
    Print out some help information.
    Here we print some stupid, cryptic message and a list of the 
    command words.*/

    private void printHelp() 
    {
        System.out.println("Voc� est� vagando pelos esgotos da cidade.");
        System.out.println();
        System.out.println("Seus comandos s�o:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Ir para onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null)
            System.out.println("N�o tem uma sa�da.");
        else {
            Itens i = encontraItem("disfarce");

            if(i != null || checharInimigoDormindo(direction)){
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
    }

    private void steal(Command command){    
        if(!command.hasSecondWord()){
            System.out.println("Roubar quem?");
            return;
        }

        String stealF = command.getSecondWord();
        NPCs a = currentRoom.getNpc(stealF);
        if(a!=null){
            if(a.roubado == false){
                if(a.getNome().equals(mercador_pierre.getNome())){
                    a.steal(itensP);
                    randomNumber = minGoldPorRoubo+goldRandom.nextInt(maxGoldPorRoubo);
                    gold += randomNumber;
                    System.out.println("+ $" + randomNumber);
                    a.setRoubado(true);
                    System.out.println("Voc� rouba o colar de ouro, sem que Pierre saiba, assim retornando para Raul.");
                    main.setExit("leste", el1);
                    currentRoom = main;
                    System.out.println(currentRoom.getLongDescription());
                    NPCs r = currentRoom.getNpc("Raul");
                    r.addIndexFala(1);
                    System.out.println(r.falar());

                }else {
                    a.steal(itensP);
                    if(a instanceof NPCquest == false && a instanceof NPCloja == false){
                        audio.PlaySound(roubarSom);
                        randomNumber = minGoldPorRoubo+goldRandom.nextInt(maxGoldPorRoubo);
                        gold += randomNumber;
                        System.out.println("+ $" + randomNumber);
                        a.setRoubado(true);
                    }
                }
            }else System.out.println("Este indiv�duo j� foi roubado.");
        }
        else{
            Itens i = currentRoom.roubarItem(stealF);
            if(i!=null){
                if(i == calice){
                    if(currentRoom == cn6){
                        if(checharInimigoDormindo("item") == true){
                            itensP.add(i);
                            System.out.println("Voc� rouba o c�lice valioso com sucesso, assim voltando a Raul.");
                            main.setExit("sul", es1);
                            currentRoom = main;
                            System.out.println(currentRoom.getLongDescription());
                            NPCs r = currentRoom.getNpc("Raul");
                            r.addIndexFala(1);
                            System.out.println(r.falar());
                        }
                    }
                }

                else if(i == coroa){
                    if(currentRoom == cl5){
                        itensP.add(i);
                        System.out.println("Voc� rouba a coroa real e volta imediatamente para Raul, mais uma vez com um trabalho bem feito.");
                        main.setExit("oeste", eo1);
                        currentRoom = main;
                        System.out.println(currentRoom.getLongDescription());
                        NPCs r = currentRoom.getNpc("Raul");
                        r.addIndexFala(1);
                        System.out.println(r.falar());
                    }
                }else itensP.add(i);
            }else System.out.println("Nome invalido");   
        }
    }

    private void comprar(Command command){
        if(!command.hasSecondWord()){
            System.out.println("Deseja comprar de quem? ");
            return;
        }
        String comprarI = command.getSecondWord();
        NPCs a = currentRoom.getNpc(comprarI);
        if(a!=null && a instanceof NPCloja){
            System.out.println("Seu GOLD: " + this.gold);
            a.printItem();
        }
        else{
            a = currentRoom.getNpcLoja();
            if(a instanceof NPCloja){
                Itens i = a.comprar(comprarI);
                if(i!=null && currentRoom.getNpc("Remi") != null){
                    if(this.gold >= i.getPreco()){
                        if(i == this.dardo){
                            this.dardos ++;
                            this.gold -= i.getPreco();
                            System.out.println("Item comprado!");
                        }else if(i == this.ima){
                            this.minGoldPorRoubo = 5;
                            this.maxGoldPorRoubo = 9;
                            this.gold -= i.getPreco();
                            NPCs n = currentRoom.getNpc("Remi");
                            n.deletaItem("ima");
                            System.out.println("Im� comprado, agora voc� ganhar� mais por roubo!");
                        }else if(i == this.disfarce){
                            itensP.add(i);
                            NPCs n = currentRoom.getNpc("Remi");
                            n.deletaItem("ima");

                            this.gold -= i.getPreco();
                            System.out.println("Disfarce comprado, agora voc� pode passar pelos guardas sem ser detectado!");

                        }else if(i == this.informacao){
                            itensP.add(i);
                            NPCs n = currentRoom.getNpc("Remi");
                            n.deletaItem("informacao");
                            this.gold -= i.getPreco();

                            System.out.println("Informa��o comprada, digite informacao para mostrar!");
                        }System.out.println("Seu GOLD: " + this.gold);
                    }else System.out.println("Gold insuficiente!");
                }else
                    System.out.println("Nome inv�lido");
            }else System.out.println("N�o posso comprar deste indiv�duo");
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Sair o que?");
            return false;
        }
        else
            return true;  // signal that we want to quit
    }

    private void falar(Command command){
        try{
            if(!command.hasSecondWord()){
                System.out.println("Deseja falar com quem? ");
            }

            String falarT = command.getSecondWord();
            NPCs a = currentRoom.getNpc(falarT);
            if(a!=null){
                if(a == baltazar){
                    System.out.println(a.falar());
                    Thread.sleep(10000);
                    audio.PlaySound(tiroSom);
                    System.out.println("Seu GOLD no final de sua jornada: " + this.gold);
                    System.out.println("Obrigado por jogar ROI DES RATS, esperamos que tenha gostado!");
                    wantToQuit = true;

                }else System.out.println(a.falar());
            }
        }catch (Exception e){
        }
    }

    private void mostraInventario(){
        System.out.println("------INVENTARIO------");
        System.out.println("GOLD: $" + gold + " \n" + "DARDOS: " + dardos + " \n" + "ITENS: " + " \n");
        for(Itens p: itensP){
            if(p!=null)
                System.out.println(p.getNome());
        }
    }

    private void dardo(Command command){
        if (this.dardos > 0){
            if(!command.hasSecondWord()){
                System.out.println("Atirar dardo em que inimigo?");
            }
            String dardoNpc = command.getSecondWord();
            NPCs a = currentRoom.getNpc(dardoNpc);
            if(a!=null){
                if(a instanceof NPCinimigo){
                    if(a.getDorme() == false){
                        audio.PlaySound(dardoSom);
                        this.dardos -= 1;
                        a.dormir();
                    }else System.out.println("Alvo j� est� dormindo");
                }else System.out.println("Alvo inv�lido");
            }else System.out.println("Alvo inexistente");
        }else System.out.println("Voc� n�o tem dardos no momento.");
    }

    private void usar(Command command){
        if(!command.hasSecondWord()){
            System.out.println("Deseja usar o que? ");
        }
        String itemUsado = command.getSecondWord();
        Itens i = encontraItem(itemUsado);
        if(i!=null){

            if(i == this.chave_catedral ){
                if(currentRoom == this.cn5){
                    cn5.mudarDescricao("Voc� est� na sacristia, onde guardam as vestes e objetos usados na missa. \nA sua frente, no fundo sala, � poss�vel ver uma porta que leva ao dep�sito, ou cofre da igreja. A porta est� aberta e voc� ouve sons de guardas de dentro da sala.");
                    cn5.setExit("norte", cn6); cn6.setExit("sul", cn5);
                    audio.PlaySound(portaSom);
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println("PORTA ABERTA COM SUCESSO! ");
                }else System.out.println("Preciso usar na porta certa! ");
            }else if(i == this.fumaca){
                if(currentRoom == this.co5){
                    System.out.println("Voc� usa a bomba de fuma�a e imediatamente rouba a pintura, assim voltanto vitoriosamente para Raul! ");
                    audio.PlaySound(bombaSom);
                    itensP.add(pintura);
                    currentRoom = main;
                    System.out.println(currentRoom.getLongDescription());
                    NPCs r = currentRoom.getNpc("Raul");
                    r.addIndexFala(1);
                    System.out.println(r.falar());
                    System.out.println("CHAVE DO RATO ADICIONADO AO INVENTARIO!");
                    itensP.add(chave_rato);
                }else System.out.println("Preciso usar a bomba de fuma�a na sala da pintura! ");
            }else if(i == this.chave_rato){
                if(currentRoom == this.cl4){
                    cl4.mudarDescricao("Voc� insere a chave no cadeado e a porta se abre, revelando o caminho at� a sala do trono.");
                    cl4.setExit("sul", f1);
                    audio.PlaySound(portaSom);
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println("PORTA ABERTA COM SUCESSO... ");
                }
            }
        }else System.out.println("Nome de item inv�lido/Voc� n�o possui o item");
    }

    private void informacao(){
        Itens i = encontraItem("informacao");
        if(i != null){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|                       INFORMA��ES                                 |");
            System.out.println("|                    NORTE - 3 inimigos                             |");
            System.out.println("|                    SUL   - 1 inimigo                              |");
            System.out.println("|                    LESTE - 4 inimigos                             |");
            System.out.println("|                    OESTE - 2 inimigos                             |");
            System.out.println("|                    FINAL - ??????????                             |");
            System.out.println("---------------------------------------------------------------------");

        }else System.out.println("Voc� n�o possui o item informa��o.");
    }

    private Itens encontraItem(String item){
        Itens i = null;
        for(Itens c: itensP){
            if(c.getNome().equals(item)){
                i = c;
            }
        }
        return i;
    }

    private boolean checharInimigoDormindo(String direction){
        for(String x: currentRoom.getNpcInimigo().split(" ")){
            NPCs c = currentRoom.getNpc(x);
            if(c != null){

                if(c.getPosicao().equals(direction) && c.getDorme() == false){
                    System.out.println("H� um guarda a sua frente, use um dardo para faz�-lo dormir. ");
                    return false;
                }
            }
        }return true;

    }
}
