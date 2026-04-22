import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CollectPanel extends JPanel {
    public CollectPanel(MeasurementController controller, MainFrame frame) {
        setLayout(new BorderLayout());
        String[] columns = {"Metric", "Value", "Score (1-5)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        JButton calcBtn = new JButton("Calculate & Analyse");
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(calcBtn, BorderLayout.SOUTH);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                model.setRowCount(0);
                for (Dimension d : controller.getScenario().getDimensions()) {
                    for (Metric m : d.getMetrics()) {
                        model.addRow(new Object[]{m.getName(), "", ""});
                    }
                }
            }
        });

        calcBtn.addActionListener(e -> {
            int row = 0;
            for (Dimension d : controller.getScenario().getDimensions()) {
                for (Metric m : d.getMetrics()) {
                    m.setValue(Double.parseDouble(table.getValueAt(row++, 1).toString()));
                }
            }
            frame.showPanel("5");
        });
    }
}