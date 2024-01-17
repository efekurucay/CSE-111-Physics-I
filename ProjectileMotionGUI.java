import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
//https://chat.openai.com/share/75472f9c-3e92-46be-a72a-8571d001696d
public class ProjectileMotionGUI extends JFrame {

    private JTextField studentNumField;
    private JButton drawButton;
    private JPanel drawingPanel;

    final public static double g = 9.8;

    public ProjectileMotionGUI() {
        setTitle("Projectile Motion Path");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for user input and drawing
        JPanel inputPanel = new JPanel();
        studentNumField = new JTextField(10);
        drawButton = new JButton("Draw");
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawProjectilePath(g, studentNumField.getText());
            }
        };

        inputPanel.add(new JLabel("Student Number:"));
        inputPanel.add(studentNumField);
        inputPanel.add(drawButton);

        // Add ActionListener to the Draw button
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.repaint();
            }
        });

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void drawProjectilePath(Graphics g, String studentNum) {
        Graphics2D g2d = (Graphics2D) g;

        int boxWidth = drawingPanel.getWidth() - 20;
        int boxHeight = drawingPanel.getHeight() - 20;

        int initialX = 10;
        int initialY = drawingPanel.getHeight() - 10;

        double timeInterval = calculateTimeOfFlight(studentNum) / 100; // Divide time into intervals for smoother curve

        g2d.setColor(Color.BLUE);
        Path2D path = new Path2D.Double();
        path.moveTo(initialX, initialY);

        for (double t = 0; t <= calculateTimeOfFlight(studentNum); t += timeInterval) {
            double x = initialX + calculateRange(studentNum) * t / calculateTimeOfFlight(studentNum);
            double y = initialY - calculateProjectileHeight(studentNum, t);
            path.lineTo(x, y);
        }

        g2d.draw(path);
    }

    private double calculateProjectileHeight(String studentNum, double time) {
        double x = Math.toRadians(angleWithHorizontal(studentNum));
        double sin = Math.sin(x);

        return (initialVelocity(studentNum) * sin * time) - ((g * time * time) / 2);
    }

    private int initialVelocity(String studentNum) {
        String initialVelocityString = studentNum.substring(2, 4);
        return 2 * Integer.parseInt(initialVelocityString);
    }

    private int angleWithHorizontal(String studentNum) {
        int length = studentNum.length();
        String angleString = studentNum.substring(length - 2, length);
        int angle = Integer.parseInt(angleString);

        if (angle < 20) return angle + 20;
        else return angle;
    }

    private double calculateTimeOfFlight(String studentNum) {
        double x = Math.toRadians(angleWithHorizontal(studentNum));
        double sin = Math.sin(x);
        return (2 * initialVelocity(studentNum) * sin) / g;
    }

    private double calculateRange(String studentNum) {
        double x = Math.toRadians(angleWithHorizontal(studentNum));
        double cos = Math.cos(x);
        double t = calculateTimeOfFlight(studentNum);

        return initialVelocity(studentNum) * cos * t;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProjectileMotionGUI());
    }
}
