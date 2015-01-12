package fjorde;

import java.util.List;

/**
 * @author Alexandre BAPTISTE
 */
public class Bag {

    private List<Items> remaining;
    private int i = 0 , j =0;

    public Bag(){
        while( i < 3 ){
            remaining.add(new Items(true,false));
        }
        while( j < 19 ) {
            remaining.add(new Items(false,true));
        }
    }
}
