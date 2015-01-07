package fjorde;
import com.sun.xml.internal.bind.v2.TODO;
import sun.awt.Symbol;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Alexandre BAPTISTE
 */
public class Support {

    public static final int nbTiles = 40;
    private Tile tile;
    private List<Tile> TileList;
    private static Map<Tile, Image> hexaImg = new HashMap<>();
    private Deck deck = new Deck()

    /*private void loadDeck() {
        try(BufferedReader reader = new BufferedReader(new FileReader(IMG_HEXA))){
            String content = reader.readLine();

            for(int i=0; i<content.length(); i++) {
                String part = content.substring(i,i+1);


            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    */

    private void loadImage(){

        Image img = null;
        try{
            img = ImageIO.read(new File(String.format("./img/%s.png", Tile.getSymbol())));
        }
        catch(IOException e){
            e.printStackTrace();
        }

        hexaImg.put(#TODO);


    }
}
