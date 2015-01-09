package fjorde;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexandre BAPTISTE
 */
public class Support {

    public static final int nbTiles = 40;
    private Tile tile;
    private List<Tile> tileList;
    private Deck deck;
    private static Map<Tile, Image> hexaImg = new HashMap<Tile, Image>();

    private void loadDeck() {
        tileList = Tiles.samples(40);
        deck = new Deck(tileList);    }


    /*private void loadImage(){
        for(Tile tile: deck){
            Image img = null;
            try{
                img = ImageIO.read(new File(String.format("./img/%s.png", tile.getSymbol())));
            }
            catch(IOException e){
                e.printStackTrace();
            }

            hexaImg.put(tile,img);
        }
    }*/
}
