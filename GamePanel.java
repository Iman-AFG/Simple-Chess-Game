import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gamThread;
    Board board = new Board();

    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
       

    }

    @Override
    public void run() {
        
        //Game Loop
        double drawInterval = 1000000000 / FPS ;
        double delta = 0 ;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gamThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            
            if (delta >= 1) {
                update();

                repaint();

                delta -- ;
            }
        }
    }

    public void paintComponent(Graphics g){
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D)g;

    board.draw(g2);


    }

    public void launchGame(){
        gamThread = new Thread(this);
        gamThread.start();
    }

    private void update(){

    }

    
}
