package Tools;

import javax.swing.ImageIcon;

public class Settings {
    public static final int UNIT_SIZE = 50;
    public static final int HOW_UNITS = 15;
    public static final int GAME_UNITS = HOW_UNITS * HOW_UNITS;

    public final static int GAME_WIDTH = UNIT_SIZE * HOW_UNITS;
    public final static int GAME_HEIGHT = UNIT_SIZE * HOW_UNITS;

    public final static int BANNER_WIDTH = GAME_WIDTH;
    public final static int BANNER_HEIGHT = UNIT_SIZE * 2;

    public final static int SCREEN_WIDTH = GAME_WIDTH + 10;
    public final static int SCREEN_HEIGHT = GAME_HEIGHT + BANNER_HEIGHT + 30;
    public static final String SCREEN_TITLE = "Snake: Classic";
    public static final String HEAD_RIGHT = "src/pictures/snake_right.png";
    public static final String HEAD_LEFT = "src/pictures/snake_left.png";
    public static final String HEAD_UP = "src/pictures/snake_up.png";
    public static final String HEAD_DOWN = "src/pictures/snake_down.png";
    public static final String BODY = "src/pictures/snake_body.png";
    public static final ImageIcon SCREEN_LOGO = new ImageIcon("src/pictures/snake-logo.png");
}
