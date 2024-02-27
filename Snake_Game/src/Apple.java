import Tools.Settings;

import  java.awt.Color;
import  java.awt.Graphics;
import java.util.Random;

public class Apple {
    private static final int[] range_X = new int[Settings.GAME_HEIGHT / Settings.UNIT_SIZE];
    private static final int[] range_Y = new int[Settings.GAME_HEIGHT / Settings.UNIT_SIZE];
    static int x_location = getAppleX();
    static int y_location = getAppleY();



    public Apple(int x_location, int y_location) {
        Apple.x_location = x_location;
        Apple.y_location = y_location;
    }

    public static int getAppleX() {
        Random random = new Random();
        range_X[0] = 6;
        for (int i = 1; i < range_X.length; i++) {
            range_X[i] = range_X[i - 1] + Settings.UNIT_SIZE;
        }
        return range_X[random.nextInt(0,range_X.length)];
    }
    public static int  getAppleY() {
        Random random = new Random();
        range_Y[0] = 121;
        for (int i = 1; i < range_Y.length; i++) {
            range_Y[i] = range_Y[i - 1] +  Settings.UNIT_SIZE;
        }
        return range_Y[random.nextInt(0,range_Y.length)];
    }

    public void draw(Graphics g) {
        g.setColor(new Color(75, 166, 75));
        g.fillOval( x_location, y_location, Settings.UNIT_SIZE - 1, Settings.UNIT_SIZE - 1);
    }
}
