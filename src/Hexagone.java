/**
 * @author Alexandre BAPTISTE
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Hexagone extends JFrame {

    Plateau panelPlateau;
    JPanel panelPioches;
    JPanel panelDraw;
    JPanel panelJailsPawn;
    JailsPawn jailsPawn;
    Draw draw;

    public Hexagone() {
        setTitle("Fjorde");
        setLocation(1250, 0);
        setSize(500,500);
        setDefaultCloseOperation(3);
        mouseManager localMouseManager = new mouseManager();

        panelPlateau = new Plateau();
        panelPlateau.setBackground(Color.white);
        panelPlateau.setLayout(null);
        add(panelPlateau);
        panelPlateau.addMouseListener(localMouseManager);

        panelPioches = new JPanel(new GridLayout(2, 1));
        jailsPawn = new JailsPawn();
        draw = new Draw();
        panelPioches.add(draw);
        panelPioches.add(jailsPawn);


        add(panelPioches, BorderLayout.EAST);
        setVisible(true);
    }

    private class mouseManager extends MouseAdapter
    {
        private mouseManager() {}

        public void mousePressed(MouseEvent paramMouseEvent)
        {
            if ( paramMouseEvent.getButton() == 1) {
                panelPlateau.clic(paramMouseEvent.getX(), paramMouseEvent.getY(), draw.getSelectedTile());
            }
        }
    }

    public static void main(String[] args) {
        new Hexagone();
    }
}