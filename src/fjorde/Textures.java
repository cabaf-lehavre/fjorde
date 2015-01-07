package fjorde;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Textures {
    private Textures() {}

    /**
     * Load all textures present in a directory
     * @param baseDir a non-null file
     * @return a non-null map from tile symbol to non-null texture
     */
    public static Map<String, Image> load(File baseDir) {
        File[] children = baseDir.listFiles();
        if (children == null) {
            throw new IllegalArgumentException();
        }

        Map<String, Image> textures = new HashMap<String, Image>();

        for (File child : children) {
            if (child.isDirectory() || !child.getName().endsWith("png")) {
                continue;
            }

            try {
                BufferedImage img = ImageIO.read(child);
                textures.put(child.getName(), img);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return textures;
    }
}
