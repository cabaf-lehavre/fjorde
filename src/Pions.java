/**
 * Created by Hawk on 05/01/2015.
 */
public class Pions {
    private Couleur couleur;

    public Pions(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Pion(" + couleur + ')';
    }
}
