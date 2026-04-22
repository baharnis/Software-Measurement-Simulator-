import javax.swing.*;
import java.awt.*;

public class DefinePanel extends JPanel {
    public DefinePanel(MeasurementController controller, MainFrame frame) {
        setLayout(new GridLayout(6, 1, 10, 10));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        JRadioButton productBtn = new JRadioButton("Product Quality", true);
        JRadioButton processBtn = new JRadioButton("Process Quality");
        productBtn.setBackground(Color.WHITE);
        processBtn.setBackground(Color.WHITE);

        ButtonGroup group = new ButtonGroup();
        group.add(productBtn);
        group.add(processBtn);

        JComboBox<String> modeBox = new JComboBox<>(new String[]{"Education", "Health", "Custom"});
        JButton nextBtn = new JButton("Initialize Scenario");

        add(new JLabel("Select Quality Type:"));
        add(productBtn);
        add(processBtn);
        add(new JLabel("Select Mode:"));
        add(modeBox);
        add(nextBtn);

        nextBtn.addActionListener(e -> {
            String type = productBtn.isSelected() ? "Product Quality" : "Process Quality";
            controller.initializeScenario((String) modeBox.getSelectedItem(), type);
            frame.showPanel("3");
        });
    }
}