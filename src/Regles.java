import fjorde.Player;
import fjorde.Tile;
import fjorde.TileItem;
import fjorde.items.Jail;
import fjorde.items.Plain;

/**
 * @author Brieuc DE TAPPIE
 */
public class Regles {
    public static boolean canPutJail(Tile t){

        int i;
        for (i = 0; i < Tile.CORNERS; i++) {
            TileItem ti = t.getCorner(i);
            if(ti instanceof Plain)
                break;
        }
        if(i==Tile.CORNERS)
            return false;
        if (t==null)
            return true;
        else return false;
    }
    public static boolean canPutpawn(Tile t, Player p){


        Tile neighbour;
        for (int i = 0; i < Tile.CORNERS ; i++) {
                neighbour = t.getNeighbour(i);
                if(neighbour.getItem() instanceof Jail && neighbour.getItem().getOwner().equals(p))
                {
                    if(t.getCorner(i) instanceof Plain || t.getCorner((i+1)%Tile.CORNERS) instanceof Plain)
                        return true;
                }
        }

        return false;
    }

}
