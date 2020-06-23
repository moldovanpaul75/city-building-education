package Presentation;

import Business.Tile;
import Business.TileType;
import DataAccess.TileDataMapper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TilePanel extends JPanel implements MouseListener {

    private static final int BOARD_THICKNESS = 2;
    private final Color hoverColor = new Color(120, 255, 120, 145);

    private int panelCols;
    private int panelRows;
    private int pixelSize;

    private Tile[][] tiles;

    public TilePanel(Tile[][] tiles, int panelCols, int panelRows, int pixelSize) {
        this.tiles = tiles;
        this.panelCols = panelCols;
        this.panelRows = panelRows;
        this.pixelSize = pixelSize;

        int preferredWidth = panelCols * pixelSize;
        int preferredHeight = panelRows * pixelSize;

        this.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());

        int rectWidth = getWidth() / panelCols;
        int rectHeight = getHeight() / panelRows;

        BufferedImage image = null;

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(BOARD_THICKNESS));

        int x, y;
        for (int i = 0; i < panelRows; i++) {
            for (int j = 0; j < panelCols; j++) {
                x = i * rectWidth;
                y = j * rectHeight;

                try {
                    image = ImageIO.read(new File(tiles[i][j].getTileType().getIconPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Image image1 = image.getScaledInstance(pixelSize, pixelSize, Image.SCALE_DEFAULT);
                g2d.drawRect(x, y, rectWidth, rectHeight);
                g2d.drawImage(image1, x, y, null);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(this.tiles[e.getX() / pixelSize][e.getY() / pixelSize] + "\n" + this.tiles[e.getX() / pixelSize][e.getY() / pixelSize].getTileType());
        if (this.tiles[e.getX() / pixelSize][e.getY() / pixelSize].getTileInfo() != null)
            System.out.println(this.tiles[e.getX() / pixelSize][e.getY() / pixelSize].getTileInfo() + "\n");
    }

    //todo hover color change
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getModifiers() == 16) {

        } else {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }
}
