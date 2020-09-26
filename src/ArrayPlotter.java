import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 *
 * @author Christopher
 */
public class ArrayPlotter extends JFrame implements KeyListener, MouseMotionListener, MouseListener
{

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension offDimension;
    Image offImage;
    Graphics2D offGraphics;
    int width;
    int height;
    int blockSize;
    int [] [] currGrid;

    Color [] cols = new Color[]
            {
                    Color.WHITE,
                    Color.MAGENTA,
                    Color.YELLOW,
                    Color.PINK,
                    Color.DARK_GRAY,
                    Color.RED,
                    Color.GREEN,
                    Color.BLUE,
                    Color.YELLOW
            };



    public ArrayPlotter(int height, int width, int blockSize)
    {
        this.width = width;
        this.height = height;
        this.blockSize = blockSize;
    }

    public void start()
    {
        addKeyListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
        init();
    }

    public void init()
    {
        setBounds(screenSize.width / 2 - width, screenSize.height / 2 - height, screenSize.width, screenSize.height);
        setSize(width*blockSize + 30, height*blockSize + 60);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g)
    {
        paintComponents(g);
    }

    @Override
    public void paintComponents(Graphics g)
    {
        if ((offGraphics == null)
                || (screenSize.width != offDimension.width)
                || (screenSize.height != offDimension.height))
        {
            offDimension = screenSize;
            offImage = createImage(screenSize.width, screenSize.height);
            offGraphics = (Graphics2D) offImage.getGraphics();
            offGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        }

        offGraphics.setColor(getBackground());
        offGraphics.fillRect(0, 0, screenSize.width, screenSize.height);
        offGraphics.setColor(Color.black);

        draw(offGraphics);
        g.drawImage(offImage, 0, 0, this);

    }

    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        int startx = blockSize;
        int starty = 35;

        if(currGrid != null) {
            for (int row = 0; row < currGrid[0].length; row++) {
                for (int[] ints : currGrid) {
                    int block = Math.abs(ints[row]);
                    if (block >= cols.length) {
                        block = block % cols.length;
                    }
                    Polygon square = makeRect(startx, starty, blockSize, blockSize);
                    g.setColor(cols[block]);

                    g.fillPolygon(square);
                    g.setColor(Color.black);

                    g.drawPolygon(square);

                    startx += blockSize;
                }
                startx = blockSize;
                starty += blockSize;
            }

        }

    }

    public Polygon makeRect(int x, int y, int width, int height)
    {
        Polygon rect = new Polygon();

        rect.addPoint(x, y);
        rect.addPoint(x, y + height);
        rect.addPoint(x + width, y + height);
        rect.addPoint(x + width, y);

        return rect;
    }

    public void update(int [] [] field)
    {
        currGrid = field;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
            case VK_Q:
                break;
            case VK_SPACE:
                break;
            case VK_LEFT:
                break;
            case VK_RIGHT:
                break;
            case VK_UP:
                break;
            case VK_DOWN:
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

}
