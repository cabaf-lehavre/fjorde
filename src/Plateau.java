import javax.swing.*;
import java.awt.*;

public class Plateau extends JPanel {

    private Territoire[][] tabT;
    private Polygon[][] tabP;

    public Plateau() {
        tabT = new Territoire[50][50];
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

    public void clic(int x, int y) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (tabP[i][j].contains(x, y)) {
                    System.out.println("Polygon " + i + ", " + j);
                    if (tabT[i][j] == null) {
                        tabT[i][j] = new Territoire();
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
                Polygon p2 = tabP[i][j];
                g.drawPolygon(p2);
                if (tabT[i][j] != null) {
                    Polygon p = tabP[i][j];
                    Territoire t = tabT[i][j];

                    g.setColor(Color.green);
                    g.fillPolygon(p);

                    g.setColor(Color.blue);
                    int x[] = {p.xpoints[0], p.xpoints[1], p.xpoints[1] + (p.xpoints[2] - p.xpoints[1]) / 2, p.xpoints[5] + (p.xpoints[4] - p.xpoints[5]) / 2, p.xpoints[5]};
                    int y[] = {p.ypoints[0], p.ypoints[1], p.ypoints[1] + (p.ypoints[2] - p.ypoints[1]) / 2, p.ypoints[5] + (p.ypoints[4] - p.ypoints[5]) / 2, p.ypoints[5]};
                    g.fillPolygon(x, y, 5);
                }
            }
        }
    }
}