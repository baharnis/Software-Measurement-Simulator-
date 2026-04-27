import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AnalysePanel extends JPanel {
    private MeasurementController controller;
    private JPanel chartArea;

    public AnalysePanel(MeasurementController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JButton showBtn = new JButton("Show Gap Analysis & Radar Chart");
        add(showBtn, BorderLayout.NORTH);


        chartArea = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                renderRadar(g);
            }
        };
        chartArea.setBackground(Color.WHITE);
        add(chartArea, BorderLayout.CENTER);

        showBtn.addActionListener(e -> {

            chartArea.revalidate();
            chartArea.repaint();
            showGapDialog();
        });
    }

    private void renderRadar(Graphics g) {
        if (controller.getScenario() == null) return;
        List<Dimension> dims = controller.getScenario().getDimensions();
        int count = dims.size();
        if (count < 2) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cx = chartArea.getWidth() / 2;
        int cy = chartArea.getHeight() / 2;
        int maxR = Math.min(chartArea.getWidth(), chartArea.getHeight()) / 3;


        g2.setColor(Color.LIGHT_GRAY);
        for (int i = 1; i <= 5; i++) {
            int r = maxR * i / 5;
            g2.drawOval(cx - r, cy - r, 2 * r, 2 * r);
        }

        int[] xPts = new int[count];
        int[] yPts = new int[count];

        for (int i = 0; i < count; i++) {
            double angle = 2 * Math.PI * i / count;
            double score = dims.get(i).calculateScore();


            int xEnd = cx + (int) (maxR * Math.cos(angle));
            int yEnd = cy + (int) (maxR * Math.sin(angle));
            g2.setColor(Color.DARK_GRAY);
            g2.drawLine(cx, cy, xEnd, yEnd);
            g2.drawString(dims.get(i).getName() + ": " + String.format("%.1f", score), xEnd, yEnd);


            xPts[i] = cx + (int) ((maxR * score / 5.0) * Math.cos(angle));
            yPts[i] = cy + (int) ((maxR * score / 5.0) * Math.sin(angle));
        }


        g2.setColor(new Color(0, 120, 255, 80));
        g2.fillPolygon(xPts, yPts, count);
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));
        g2.drawPolygon(xPts, yPts, count);
    }

    private void showGapDialog() {
        StringBuilder sb = new StringBuilder("Gap Analysis (Goal: 5.0):\n\n");
        for (Dimension d : controller.getScenario().getDimensions()) {
            double score = d.calculateScore();
            double gap = 5.0 - score;
            sb.append(d.getName()).append("\nScore: ").append(String.format("%.2f", score))
                    .append("\nGap: ").append(String.format("%.2f", gap)).append("\n---\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Final Analysis", JOptionPane.INFORMATION_MESSAGE);
    }
}