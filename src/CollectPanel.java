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
                if (controller.getScenario() != null) {
                    for (Dimension d : controller.getScenario().getDimensions()) {
                        for (Metric m : d.getMetrics()) {
                            model.addRow(new Object[]{m.getName(), "", ""});
                        }
                    }
                }
            }
        });

        calcBtn.addActionListener(e -> {
            try {
                int row = 0;
                for (Dimension d : controller.getScenario().getDimensions()) {
                    for (Metric m : d.getMetrics()) {
                        String valueStr = table.getValueAt(row++, 1).toString();
                        m.setValue(Double.parseDouble(valueStr));
                    }
                }

                frame.showPanel("5");
                frame.getContentPane().repaint();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values!");
            }
        });
    }
}