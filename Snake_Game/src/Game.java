import Tools.Control;
import Tools.Settings;
import Tools.Shape;

import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {
    Shape banner, background, foreground;
    static int startX = Settings.UNIT_SIZE * 2 + 6; //106
    static int startY = Settings.UNIT_SIZE * 2 + 21; //121
    int scoreCount = 0;
    int delay = 100;
    private final Snake snake;
    private final Apple apple;
    static boolean isRunning;
    String end;
    public Game() {
        this.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
        background = new Shape(0, 0, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        banner = new Shape(5, 10, Settings.BANNER_WIDTH, Settings.BANNER_HEIGHT);
        foreground = new Shape(banner.x, (Settings.UNIT_SIZE + banner.y) * 2, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);

        snake = new Snake(startX, startY);
        apple = new Apple(Apple.x_location,Apple.y_location);

        addKeyListener( new Control());
        setFocusable(true);
        startGame();
    }

    public void startGame() {
        isRunning = true;
        for (int i = 0; i < Snake.size; i++) {
            Snake.location_X[i] = startX - i * Settings.UNIT_SIZE;
            Snake.location_Y[i] = startY;
        }
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGameObjects(g);
    }

    private void drawGameObjects(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(215, 215, 215));
        g2.fill(new Rectangle2D.Double(background.x, background.y, background.width, background.height));

        g2.setColor(Color.BLACK);
        g2.draw(new Rectangle2D.Double(banner.x, banner.y, banner.width, banner.height));
        g2.draw(new Rectangle2D.Double(foreground.x, foreground.y, foreground.width, foreground.height));

        g2.setColor(Color.GRAY);
        g2.fill(new Rectangle2D.Double(foreground.x + 1, foreground.y + 1, foreground.width - 1, foreground.height - 1));
        g2.fill(new Rectangle2D.Double(banner.x + 1, banner.y + 1, banner.width - 1, banner.height - 1));


        if(isRunning) {
            String score = "Score: " + scoreCount;
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Ink Free",Font.BOLD,(int)banner.height / 2));
            g2.drawString(score,10, (int) (banner.y + Settings.UNIT_SIZE + 10));

            //grid
            g2.setColor(Color.BLACK);
            for (int i = 0, stepX = Settings.UNIT_SIZE + 5, stepY = Settings.UNIT_SIZE * 2 + 20; i < Settings.HOW_UNITS; i++) {
                g2.drawLine(stepX, Settings.UNIT_SIZE * 2 + 20, stepX, Settings.SCREEN_HEIGHT - 10);
                g2.drawLine(Settings.SCREEN_WIDTH - 5, stepY, 5, stepY);
                stepX += Settings.UNIT_SIZE;
                stepY += Settings.UNIT_SIZE;
            }

            apple.draw(g2);

            if(Snake.location_X[0] == Apple.x_location && Snake.location_Y[0] == Apple.y_location) {
                Apple.x_location = Apple.getAppleX();
                Apple.y_location = Apple.getAppleY();
                Snake.size += 1;
                scoreCount += 2;
            }

            snake.draw(g2);

        } else {
            end = (Snake.size == Settings.GAME_UNITS - 2) ? "You won!" : "Game Over";
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Serif",Font.BOLD,Settings.GAME_WIDTH / 10));
            g2.drawString(end,Settings.GAME_WIDTH / 4, Settings.SCREEN_HEIGHT / 2 + 40);  //SCREEN_HEIGHT / 2 + 40
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Snake.move();
        repaint();
    }
}
