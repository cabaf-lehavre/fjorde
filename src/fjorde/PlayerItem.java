package fjorde;

import fjorde.Player;

public abstract class PlayerItem
{
    private String couleur;
    private Player proprio;

    public PlayerItem(Player proprio)
    {
        this.proprio = proprio;
        this.couleur = proprio.getCouleur();
    }

    public abstract String getType();

    public String getCouleur()
    {
        return couleur;
    }

    public void setCouleur(String couleur)
    {
        this.couleur = couleur;
    }

    public Player getProprio()
    {
        return proprio;
    }

    public void setProprio(Player proprio)
    {
        this.proprio = proprio;
    }

    @Override
    public String toString()
    {
        return "PlayerItem{" +
                "couleur='" + couleur + '\'' +
                ", proprio=" + proprio +
                '}';
    }
}