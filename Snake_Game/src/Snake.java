import Tools.*;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Snake {
    final static int[] location_X = new int[Settings.GAME_UNITS];
    final static int[] location_Y = new int[Settings.GAME_UNITS];
    static ImageIcon head = new ImageIcon(Settings.HEAD_RIGHT);
    static ImageIcon body = new ImageIcon(Settings.BODY);
    static int size = 3;

    public Snake(int x, int y) {
        location_X[0] = x;
        location_Y[0] = y;
    }

    public static void step() {
        for (int i = size; i > 0; i--) {
            if(i >= 4 && Snake.location_X[0] == Snake.location_X[i] && Snake.location_Y[0] == Snake.location_Y[i]) {
                Game.isRunning = false;
                break;
            }
            location_X[i] = location_X[i - 1];
            location_Y[i] = location_Y[i - 1];

            if( i > 1 && Apple.x_location == location_X[i] && Apple.y_location == location_Y[i]) {
                Apple.x_location = Apple.getAppleX();
                Apple.y_location = Apple.getAppleY();
            }
        }
    }

    public static void move() {
        if(Control.right) {
            step();
            head = new ImageIcon(Settings.HEAD_RIGHT);
            location_X[0] = location_X[0] + Settings.UNIT_SIZE;
            if(location_X[0] > (Settings.HOW_UNITS - 1) * Settings.UNIT_SIZE + 6)
                location_X[0] = 6;
        }
        if(Control.left) {
            step();
            head = new ImageIcon(Settings.HEAD_LEFT);
            location_X[0] = location_X[0] - Settings.UNIT_SIZE;
            if(location_X[0] < 6)
                location_X[0] = (Settings.HOW_UNITS - 1) * Settings.UNIT_SIZE + 6;
        }
        if(Control.up) {
            step();
            head = new ImageIcon(Settings.HEAD_UP);
            location_Y[0] = location_Y[0] - Settings.UNIT_SIZE;
            if(location_Y[0] < Settings.UNIT_SIZE  * 2 + 21) location_Y[0] = Settings.GAME_WIDTH + Settings.UNIT_SIZE + 21;

        }
        if(Control.down) {
            step();
            head = new ImageIcon(Settings.HEAD_DOWN);
            location_Y[0] = location_Y[0] + Settings.UNIT_SIZE;
            if(location_Y[0] > Settings.GAME_WIDTH + Settings.UNIT_SIZE + 21) location_Y[0] = Settings.UNIT_SIZE  * 2 + 21;

        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < size; i++) {
            body.paintIcon(null,g,location_X[i],location_Y[i]);
        }
        head.paintIcon(null,g,location_X[0],location_Y[0]);
    }
}
