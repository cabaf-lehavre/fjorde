package fjorde;

/**
 * @author Alexandre BAPTISTE
 */
public class Items {
    private boolean isJail;
    private boolean isPawn;

    public Items( boolean isJail, boolean isPawn ){
        this.isJail = isJail;
        this.isPawn = isPawn;
    }

    public boolean isJail(Items item) {
        return false;
    }
}
