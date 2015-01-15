package fjorde;

import fjorde.Player;
import fjorde.Tile;
import fjorde.TileItem;
import fjorde.items.Jail;
import fjorde.items.Pawn;
import fjorde.items.Plain;

/**
 * @author Brieuc DE TAPPIE
 */
public class Regles {
    public static boolean canPutJail(Tile t) {
        int i;
        for (i = 0; i < Tile.CORNERS; i++) {
            TileItem ti = t.getCorner(i);
            if(ti instanceof Plain)
                break;
        }
        if(i==Tile.CORNERS)
            return false;
        if (t.getItem()==null)
            return true;
        else return false;
    }

    public static boolean canPutpawn(Tile t, Player p) {
        Tile neighbour;
        for (int i = 0; i < Tile.CORNERS ; i++) {
                neighbour = t.getNeighbour(i);

            if (neighbour == null || neighbour.getItem() == null || neighbour.getItem().getOwner() == null) {
                continue;
            }

            if (!(neighbour.getItem() instanceof Jail) && (!(neighbour.getItem() instanceof Pawn) || !neighbour.getItem().getOwner().equals(p))) {
                continue;
            }

            if (t.getCorner(i) instanceof Plain || t.getCorner((i + 1) % Tile.CORNERS) instanceof Plain) {
                return true;
            }
        }

        return false;
    }

    public static boolean canPutItem(PlayerItem item, Tile t) {
        return (item instanceof Jail && canPutJail(t)) || (item instanceof Pawn && canPutpawn(t,item.getOwner()));
    }
}
