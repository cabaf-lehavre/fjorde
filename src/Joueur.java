import java.util.LinkedList;
import java.util.List;


public class Joueur {

    private int nbPoint;

    private List<Pions> pionsChamp =new LinkedList<Pions>();
    private List<Huttes> huttesJoueur=new LinkedList<Huttes>();

    public Joueur(){}


    public List<Pions> getPionsParCouleur(){return pionsChamp;}
    public List<Huttes> getHuttesParCouleur(){return huttesJoueur;}

    public int getPoint(){return nbPoint;}


}
