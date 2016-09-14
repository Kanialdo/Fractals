import javax.swing.*;


public class FractalWindow extends JFrame {
    private JPanel panel;
    public static final int width = 1000;
    public static final int height = 750;

    public FractalWindow() {
        panel = new FractalPanel();
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setResizable(false);
    }
}
