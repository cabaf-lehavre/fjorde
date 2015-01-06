package fjorde;

public class Player
{
    private final String[] COUL = {"Rouge","Jaune"};
    private static int NUM_JOUEUR = 0;

    private int numJoueur;
    private String nom;
    private String couleur;
    private boolean doitJouer;
    private int score;

    public Player(String nom)
    {
        this.nom = nom;
        this.couleur = COUL[NUM_JOUEUR];
        this.numJoueur += NUM_JOUEUR;
        if(this.numJoueur == 1)
        {
            this.doitJouer = true;
        }
        else if (this.numJoueur == 2)
        {
            this.doitJouer = false;
        }
        this.score = 0;
    }

    public int getNumJoueur()
    {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur)
    {
        this.numJoueur = numJoueur;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }


    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getCouleur()
    {
        return couleur;
    }

    public void setCouleur(String couleur)
    {
        this.couleur = couleur;
    }

    public boolean isDoitJouer()
    {
        return doitJouer;
    }

    public void setDoitJouer(boolean doitJouer)
    {
        this.doitJouer = doitJouer;
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "numJoueur=" + numJoueur +
                ", nom='" + nom + '\'' +
                ", couleur='" + couleur + '\'' +
                ", doitJouer=" + doitJouer +
                '}';
    }
}
