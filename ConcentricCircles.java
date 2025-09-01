import javax.swing.*; // Gives us JPanel, JFrame
import java.awt.*; // Gives us Graphics2D, Color and RenderingHints

// Custom class that extends JPanel to do custom painting
public class ConcentricCircles extends JPanel {
    private static final int BORDER_GAP = 10; // Gap between border and shapes

    @Override
    protected void paintComponent(Graphics g) { // This method is called whenever a panel has to be drawn
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Gives us smoother lines

        int w = getWidth(), h = getHeight(); // The current panel height and width are retrieved
        int cx = w / 2, cy = h / 2; // The centre point of the panel is calculated
        int maxDiameter = Math.min(w, h) - 2 * BORDER_GAP; // Diameter of the largest circle that can fit in the panel

        // Draw concentric ovals
        graphics.setColor(Color.LIGHT_GRAY);
        for (int d = maxDiameter; d > 0; d -= 2 * BORDER_GAP) {
            // Loops from the largest to the smallest circle, ensuring 10 pixels gap between each oval
            int r = d / 2;
            // Top oval
            graphics.drawOval(cx - r / 2, cy - d, r, d);
            // Bottom oval
            graphics.drawOval(cx - r / 2, cy, r, d);
            // Left oval
            graphics.drawOval(cx - d, cy - r / 2, d, r);
            // Right oval
            graphics.drawOval(cx, cy - r / 2, d, r);
        }

        // Draw concentric circles
        graphics.setColor(Color.BLACK);
        for (int d = maxDiameter; d > 0; d -= 2 * BORDER_GAP) {
            // Loops from the largest to the smallest circle, ensuring 10 pixels gap between each circle
            int x = cx - d / 2, y = cy - d / 2;
            graphics.drawOval(x, y, d, d);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Concentric Ovals"); // Create a window with title
        frame.setSize(500, 500); // Set the window size 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program when window closes
        frame.add(new ConcentricCircles()); // Add custom panel to the frame
        frame.setVisible(true); // Make the window visible on the screen
    }
}