package fjorde;

import java.awt.*;
import java.util.Map;

import static unit.Assert.assertEquals;
import static unit.Assert.assertTrue;

public class TexturesTest {
    public static void main(String[] args) {
        Map<String, Image> map = Textures.loadTiles();

        assertEquals(map.size(), 88, "number of textures");
        assertTrue(map.containsKey("MMMMMM"), "has texture full of mountain");

        System.out.println("success");
    }
}
