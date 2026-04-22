import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlanPanel extends JPanel {
    public PlanPanel(MeasurementController controller, MainFrame frame) {
        setLayout(new BorderLayout());
        String[] columns = {"Metric", "Coefficient", "Direction", "Range", "Unit"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        JButton nextBtn = new JButton("Go to Collection");
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(nextBtn, BorderLayout.SOUTH);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                model.setRowCount(0);
                for (Dimension d : controller.getScenario().getDimensions()) {
                    for (Metric m : d.getMetrics()) {
                        model.addRow(new Object[]{m.getName(), m.getCoefficient(), m.getDirection(), m.getMin()+"-"+m.getMax(), m.getUnit()});
                    }
                }
            }
        });

        nextBtn.addActionListener(e -> frame.showPanel("4"));
    }
}