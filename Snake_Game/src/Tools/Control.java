package Tools;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Control extends KeyAdapter {
    public static boolean right = false;
    public static boolean left = false;
    public static boolean up = false;
    public static boolean down = false;
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> {
                Control.right = !Control.left;
                Control.up = false;
                Control.down = false;
            }
            case KeyEvent.VK_LEFT -> {
                Control.left = !Control.right;
                Control.up = false;
                Control.down = false;
            }
            case KeyEvent.VK_UP -> {
                Control.up = !Control.down;
                Control.left = false;
                Control.right = false;
            }
            case KeyEvent.VK_DOWN -> {
                Control.down = !Control.up;
                Control.right = false;
                Control.left = false;
            }
            default -> System.out.println("Use: ←, →, ↑, ↓.");
        }
    }
}
