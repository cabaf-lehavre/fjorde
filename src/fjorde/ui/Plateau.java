package fjorde.ui;

import fjorde.*;
import fjorde.items.Jail;
import fjorde.items.Pawn;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Plateau extends JPanel {

    private TileSet tiles;
    private Polygon[][] tabP;
    private Map<String, Image> textures = Textures.loadTiles();

    public Plateau() {
        tiles = new TileSet(50, 50);
        tabP = new Polygon[50][50];

        // Create background polygons
        for (int i = 0; i < 50; i++) {
            int vY = i * 30;
            for (int j = 0; j < 50; j++) {
                int vX = j * 40;
                if (i % 2 != 0)
                    vX += 20; // impair X ( +20 to decay the polygon )
                int x1[] = {20 + vX, 40 + vX, 40 + vX, 20 + vX, 0 + vX, 0 + vX};
                int y1[] = {0 + vY, 10 + vY, 30 + vY, 40 + vY, 30 + vY, 10 + vY};
                tabP[i][j] = new Polygon(x1, y1, 6);

            }
        }

        // Basics tiles presents at start of the game
        tiles.set(9, 10, Tiles.of(TileItems.PLAIN, TileItems.SEA,
                              TileItems.PLAIN, TileItems.PLAIN,
                              TileItems.MOUNTAIN, TileItems.MOUNTAIN));
        tiles.set(10, 11, Tiles.of(TileItems.PLAIN, TileItems.PLAIN,
                TileItems.PLAIN, TileItems.PLAIN,
                TileItems.PLAIN, TileItems.PLAIN));
        tiles.set(10, 10, Tiles.of(TileItems.MOUNTAIN, TileItems.PLAIN,
                TileItems.PLAIN, TileItems.PLAIN,
                TileItems.PLAIN, TileItems.PLAIN));
    }

    /**
     *
     * @param x Polygon absciss
     * @param y Polygon ordinate
     * @param tile Desired tile
     */
    public void clic(int x, int y, Tile tile) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Polygon p = tabP[i][j];
                if (!p.contains(x, y)) {
                    continue;
                }

                if (tiles.trySet(i, j, tile)) {
                    repaint();
                }
                break;
            }
        }
    }

    /**
     *
     * @param x Polygon absciss
     * @param y Polygon ordinate
     * @param item Selected item
     */
    public void clic(int x, int y, PlayerItem item) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Polygon p = tabP[i][j];
                if (!p.contains(x, y)) {
                    continue;
                }

                Tile t = tiles.tryGet(i, j);
                if (t != null) {
                    t.setItem(item);
                    repaint();
                }
                break;
            }
        }
    }

    /**
     * Main method, which allows to "add" image to background
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Polygon p = tabP[i][j];
                Tile t = tiles.tryGet(i, j);
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