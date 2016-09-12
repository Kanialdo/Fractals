import javax.swing.*;
import java.awt.*;


public class FractalPanel extends JPanel {

    private static final int maxIter = 100;


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //based on https://plus.maths.org/content/computing-mandelbrot-set
        for (int x = 0; x < FractalWindow.width; x++) {
            for (int y = 0; y < FractalWindow.height; y++) {
                double[] normalizedPosition = normalizePosition(x, y);
                double re = normalizedPosition[0];
                double im = normalizedPosition[1];

                double prevRe = 0;
                double prevIm = 0;
                int p;
                for (p = 0; p < maxIter; p++) {
                    prevRe = prevRe * prevRe - prevIm * prevIm + re;
                    prevIm = 2 * prevRe * prevIm + im;
                    if (Math.sqrt(prevRe * prevRe + prevIm * prevIm) > 2) {
                        break;
                    }
                }
                g.setColor(new Color(p * 100003 % 255, p * 100002 % 255, p*1000001 % 255));
                g.drawRect(x, y, 1, 1);

            }
        }
        repaint();

    }

    private double[] normalizePosition(int x, int y) {
        double[] normalizedPosition = new double[2];
        normalizedPosition[0] = (double) (x - getWidth()/2) / (double) getWidth()*4;
        normalizedPosition[1] = (double) (-y + getHeight()/2) / (double) getHeight()*4;
        return normalizedPosition;
    }

}
