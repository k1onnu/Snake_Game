import Tools.Settings;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Window extends JFrame {
    public Window(int width, int height, String name, ImageIcon logo) {
        add(new Game());
        this.setTitle(name);
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void getWindow() {
        new Window(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT, Settings.SCREEN_TITLE, Settings.SCREEN_LOGO);
    }
}
