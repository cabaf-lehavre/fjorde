import fjorde.Textures;
import fjorde.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Plateau extends JPanel {

    private Tile[][] tabT;
    private Polygon[][] tabP;
    private Map<String, Image> textures = Textures.load("img");

    public Plateau() {
        tabT = new Tile[50][50];
        tabP = new Polygon[50][50];

		/* Creation des Polygons, qui servent d'emplacement pour les pieces du jeu*/
        for (int i = 0; i < 50; i++) {
            int vY = i * 30; /* Vecteur de deplacement ordonnees */
            for (int j = 0; j < 50; j++) {
                int vX = j * 40; /* Vecteur deplacement abscices */
                if (i % 2 != 0)
                    vX += 20; /* Vecteur deplacement abscices suplementaire pour lignes impaires */
                int x1[] = {20 + vX, 40 + vX, 40 + vX, 20 + vX, 0 + vX, 0 + vX};
                int y1[] = {0 + vY, 10 + vY, 30 + vY, 40 + vY, 30 + vY, 10 + vY};
                tabP[i][j] = new Polygon(x1, y1, 6);
            }
        }
    }

    public void clic(int x, int y, Tile tile) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (tabP[i][j].contains(x, y)) {
                    System.out.println("Polygon " + i + ", " + j);
                    if (tabT[i][j] == null) {
                        tabT[i][j] = tile;
                        repaint();
                    }
                    break;
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Polygon p = tabP[i][j];
                Tile t = tabT[i][j];
                g.drawPolygon(p);

                if (t != null) {
                    Image texture = textures.get(t.getSymbol());
                    Rectangle bounds = p.getBounds();

                    g.drawImage(texture, (int) bounds.getX(), (int) bounds.getY(), null);
                }
            }
        }
    }
}