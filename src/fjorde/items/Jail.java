package fjorde.items;

import fjorde.Player;

/**
 * @author Florentin BENARD
 */

public class Jail extends PlayerItem
{
    public Jail(Player player)
    {
        super(player);
    }

    public String getType()
    {
        return "Jail";
    }
}
