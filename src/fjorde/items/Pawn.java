package fjorde.items;

import fjorde.Player;

/**
 * @author Florentin BENARD
 */
public class Pawn extends PlayerItem
{
    public Pawn(Player player)
    {
        super(player);
    }

    public  String getType()
    {
        return "Pawn";
    }
}
