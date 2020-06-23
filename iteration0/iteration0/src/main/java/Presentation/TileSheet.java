package Presentation;

import Business.TileType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TileSheet extends JPanel {
    private ArrayList<TileType> tileTypes;

    public TileSheet(ArrayList<TileType> tileTypes) {
        this.tileTypes = tileTypes;
        this.setPreferredSize(new Dimension(100, 500));
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());

        int rectWidth = getWidth() / 4;
        int rectHeight = getHeight() / 20;

        Graphics2D g2d = (Graphics2D) g.create();
        //g2d.setColor(Color.BLACK);
        //g2d.setStroke(new BasicStroke(1));

        BufferedImage image = null;

        int x, y;
        for (int i = 0; i < 2 * tileTypes.size(); i += 2) {
            x = 1 * rectWidth;
            y = i * rectHeight;

            try {
                image = ImageIO.read(new File(tileTypes.get(i / 2).getIconPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image1 = image.getScaledInstance(25, 25, Image.SCALE_DEFAULT);

            g2d.drawImage(image1, x, y, null);
            //g2d.drawRect(x, y, rectWidth, rectHeight);
            g2d.drawString(tileTypes.get(i / 2).getTileName(), x + 30, y + 20);
        }
    }

}
