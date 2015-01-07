/**
 * @author Alexandre BAPTISTE
 */

public class Territoire {

    private int tabSommet[];
    private Territoire tabVoisin[];
    private int coordonnees[];

    public Territoire(int[] tSommet, int[] tCoord){
        this.tabSommet = tSommet;
        this.coordonnees = tCoord;
    }

    public Territoire() {
    }

    public int[] getCoordonnees() {
        return this.coordonnees;
    }

    public int getX() {
        return this.coordonnees[0];
    }

    public int getY() {
        return this.coordonnees[1];
    }

    public int[] getSommets() {
        return this.tabSommet;
    }
}
