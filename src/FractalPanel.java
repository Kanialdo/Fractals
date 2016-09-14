import javax.swing.*;
import java.awt.*;


public class FractalPanel extends JPanel {

    private static final int maxIter = 300;


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        paintMandel(g2d);
    }

    private double[] normalizePosition(int x, int y) {
        double[] normalizedPosition = new double[2];
        normalizedPosition[0] =  (x - getWidth() / 2) / (double) getWidth() * 4;
        normalizedPosition[1] = (y - getHeight() / 2) / (double) getHeight() * 2;
        return normalizedPosition;
    }

    private void paintMandel(Graphics2D g2d) {
        //based on https://plus.maths.org/content/computing-mandelbrot-set
        for (int x = 0; x < FractalWindow.width; x++) {
            for (int y = 0; y < FractalWindow.height; y++) {
                double[] normalizedPosition = normalizePosition(x, y);
                double re = normalizedPosition[0];
                double im = normalizedPosition[1];

                double prevRe = 0;
                double prevIm = 0;
                double nextRe, nextIm;
                int p;
                for (p = 0; p < maxIter; p++) {
                    nextRe = prevRe * prevRe - prevIm * prevIm + re;
                    nextIm = 2 * prevRe * prevIm + im;
                    if (nextRe * nextRe + nextIm * nextIm > 4) {
                        break;
                    }
                    prevRe = nextRe;
                    prevIm = nextIm;
                }
                g2d.setColor(new Color(p % 255, p * 12 % 255, p * 11 % 255));
                g2d.drawRect(x, y, 1, 1);
            }
        }
        repaint();
    }
}
