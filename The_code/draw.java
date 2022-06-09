import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;


public class draw extends JFrame
{
    
    public draw()
    {
        setTitle("draw");
        setSize(1800, 1800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g)
    {
     
     g.setColor(Color.DARK_GRAY);
     g.fillOval(400, 270, 400, 470);
     g.setColor(Color.PINK);
     g.fillOval(466, 320, 270, 370);
     g.setColor(Color.DARK_GRAY);
     g.fillOval(486, 77, 200, 200);
     g.setColor(Color.DARK_GRAY);
     g.fillOval(475, 45, 70, 70);
     g.setColor(Color.DARK_GRAY);
     g.fillOval(629, 45, 70, 70);
     g.setColor(Color.PINK);
     g.fillOval(637, 55, 40, 50);
     g.setColor(Color.PINK);
     g.fillOval(495, 55, 40, 50);
     g.setColor(Color.PINK);
     g.fillOval(550, 150, 20, 30);
     g.setColor(Color.PINK);
     g.fillOval(610, 150, 20, 30);
     g.setColor(Color.PINK);
     g.fillOval(550, 230, 90, 5);
     g.setColor(Color.DARK_GRAY);
     g.fillOval(350, 300, 200, 50);
     g.setColor(Color.DARK_GRAY);
     g.fillOval(660, 300, 200, 50);
     g.setColor(Color.DARK_GRAY);
     g.fillOval(637, 700, 60, 80);
     g.setColor(Color.DARK_GRAY);
     g.fillOval(500, 700, 60, 80);
    }
    
    public static void main(String[] args)
    {
        draw t = new draw();
        t.paint(null);
    }
    
}   