import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


class Surface extends JPanel
        implements ActionListener {

    private Timer timer;
    private int count;
    private final int INITIAL_DELAY = 200;
    private final int DELAY = 80;
    private final int NUMBER_OF_LINES = 8;
    private final int STROKE_WIDTH = 3;
    private final int cemberAdet = 0;



    public Surface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        int width = getWidth();
        int height = getHeight();

        g2d.setStroke(new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND,
               BasicStroke.JOIN_ROUND));
        g2d.translate(width / 2, height / 2);

        


        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue  = rand.nextFloat();

        int radius = 10;


        for( int x = 0 ; x<radius; x++) {

            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);


            int z = radius / 2;
            g.drawOval(width / 2 - z, height / 2 - z, radius, radius);

            x++;

            radius = radius + 33;


            g2d.dispose();
        }
    }

    @Override
    public void paintComponent(Graphics g) {

       // super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
        count++;
    }
}

public class Odev2 extends JFrame {

    public Odev2() {

        initUI(); // yapılandırcı method
    }

    private void initUI() {

        add(new Surface());

        setTitle("Daireler");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

                Odev2 ex = new Odev2();
                ex.setVisible(true);

    }
}