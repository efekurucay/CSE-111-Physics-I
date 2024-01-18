
/**
*-----------------------------------------------------
* Akdeniz University CSE111 Physics
* Name: Yahya Efe Kurucay
* Date: 17.01.2024  
* Description: 2023 Fall Final Exam Homework Part Question 2
* Score: ?
* Website: https://efekurucay.com
*-----------------------------------------------------
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class TrajectoryChart extends JFrame {

    private JTextField studentNumField;
    private JLabel initialVelocityLabel;
    private JLabel timeOfFlightLabel;
    private JLabel maxHeightLabel;
    private JLabel rangeLabel;

    public TrajectoryChart() {
        super("Projectile Motion Trajectory");

        studentNumField = new JTextField(10);
        JButton drawButton = new JButton("Draw Trajectory");

        initialVelocityLabel = new JLabel("Initial Velocity: ");
        timeOfFlightLabel = new JLabel("Time of Flight: ");
        maxHeightLabel = new JLabel("Max Height: ");
        rangeLabel = new JLabel("Range: ");

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentNum = studentNumField.getText();
                if (!studentNum.isEmpty()) {
                    drawTrajectory(studentNum);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a student number.");
                }
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Student Number: "));
        controlPanel.add(studentNumField);
        controlPanel.add(drawButton);
        controlPanel.add(initialVelocityLabel);
        controlPanel.add(timeOfFlightLabel);
        controlPanel.add(maxHeightLabel);
        controlPanel.add(rangeLabel);

        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.add(createChartPanel(), BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(chartPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void drawTrajectory(String studentNum) {
        XYSeries trajectorySeries = new XYSeries("Trajectory");

        double initialVelocity = Final.initialVelocity(studentNum);
        double angle = Math.toRadians(Final.angleWithHorizontal(studentNum));
        double timeStep = Final.calculateTimeOfFlight(studentNum) / 100;

        for (double t = 0; t <=Final. calculateTimeOfFlight(studentNum); t += timeStep) {
            double x = initialVelocity * Math.cos(angle) * t;
            double y = initialVelocity * Math.sin(angle) * t - 0.5 * Final.g * t * t;
            trajectorySeries.add(x, y);
        }

        updateLabels(studentNum);

        XYSeriesCollection dataset = new XYSeriesCollection(trajectorySeries);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Projectile Motion Trajectory",
                "Horizontal Distance (m)",
                "Vertical Distance (m)",
                dataset
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));

        getContentPane().remove(1); // Remove the old chartPanel
        getContentPane().add(chartPanel, BorderLayout.CENTER);
        pack();
    }

    private void updateLabels(String studentNum) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

    double initialVelocity = Final.initialVelocity(studentNum);
    double timeOfFlight = Final.calculateTimeOfFlight(studentNum);
    double maxHeight = Final.calculateMaxHeight(studentNum);
    double range = Final.calculateRange(studentNum);

    initialVelocityLabel.setText("Initial Velocity: " + decimalFormat.format(initialVelocity));
    timeOfFlightLabel.setText("Time of Flight: " + decimalFormat.format(timeOfFlight));
    maxHeightLabel.setText("Max Height: " + decimalFormat.format(maxHeight));
    rangeLabel.setText("Range: " + decimalFormat.format(range));
    }

    private JPanel createChartPanel() {
        XYSeries dummySeries = new XYSeries("Dummy");
        dummySeries.add(0, 0);

        XYSeriesCollection dummyDataset = new XYSeriesCollection(dummySeries);
        JFreeChart dummyChart = ChartFactory.createXYLineChart(
                "",
                "",
                "",
                dummyDataset
        );

        ChartPanel chartPanel = new ChartPanel(dummyChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        return chartPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrajectoryChart example = new TrajectoryChart();
            example.setVisible(true);
        });
    }

    // Diğer metodları buraya ekleyebilirsiniz
}
