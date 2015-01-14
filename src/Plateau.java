import fjorde.PlayerItem;
import fjorde.Textures;
import fjorde.Tile;
import fjorde.items.Jail;
import fjorde.items.Pawn;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Plateau extends JPanel {

    private Tile[][] tabT;
    private Polygon[][] tabP;
    private Map<String, Image> textures = Textures.loadTiles();

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
                    //System.out.println(tile.canPutTile(tile));
                    if (tabT[i][j] == null) {
                        tabT[i][j] = tile;
                        repaint();
                    }
                    break;
                }
            }
        }
    }

    public void clic(int x, int y, PlayerItem item) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Polygon p = tabP[i][j];
                if (!p.contains(x, y)) {
                    continue;
                }
                Tile t = tabT[i][j];
                if (t != null) {
                    t.setItem(item);
                    repaint();
                }
                break;
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

                    PlayerItem item = t.getItem();
                    if (item instanceof Jail) {
                        drawJailInMiddleOf(g, bounds);
                    } else if (item instanceof Pawn) {
                        drawPawnInMiddleOf(g, bounds);
                    }
                }
            }
        }
    }

    private void drawJailInMiddleOf(Graphics g, Rectangle bounds) {
        drawCircleInMiddleOf(g, bounds, 18);
    }

    private void drawPawnInMiddleOf(Graphics g, Rectangle bounds) {
        drawCircleInMiddleOf(g, bounds, 10);
    }

    private void drawCircleInMiddleOf(Graphics g, Rectangle bounds, int size) {
        g.fillOval((int) bounds.getCenterX() - size / 2, (int) bounds.getCenterY() - size / 2, size, size);
    }
}