import javax.swing.*;
import java.awt.*;

public class AnalysePanel extends JPanel {
    public AnalysePanel(MeasurementController controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        JButton showBtn = new JButton("Show Results");
        add(showBtn);

        showBtn.addActionListener(e -> {
            removeAll();
            double lowestScore = 6.0;
            String weakestDim = "";

            for (Dimension d : controller.getScenario().getDimensions()) {
                double score = d.calculateScore();
                JProgressBar bar = new JProgressBar(0, 50);
                bar.setValue((int)(score * 10));
                bar.setString(d.getName() + ": " + String.format("%.2f", score));
                bar.setStringPainted(true);
                add(bar);

                if (score < lowestScore) {
                    lowestScore = score;
                    weakestDim = d.getName();
                }
            }

            add(new JLabel("Gap Analysis: " + weakestDim + " needs improvement. Gap: " + (5.0 - lowestScore)));
            revalidate(); repaint();
        });
    }
}