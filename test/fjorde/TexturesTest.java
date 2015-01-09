package fjorde;

import java.awt.*;
import java.io.File;
import java.util.Map;

import static unit.Assert.assertEquals;

public class TexturesTest {
    public static void main(String[] args) {
        Map<String, Image> map = Textures.load(new File("img"));

        assertEquals(map.size(), 88, "number of textures");

        System.out.println("success");
    }
}
