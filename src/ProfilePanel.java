import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    public ProfilePanel(MeasurementController controller, MainFrame frame) {
        setLayout(new GridLayout(4, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JTextField userField = new JTextField();
        JTextField schoolField = new JTextField();
        JTextField sessionField = new JTextField();
        JButton nextBtn = new JButton("Next");

        add(new JLabel("Username:")); add(userField);
        add(new JLabel("School:")); add(schoolField);
        add(new JLabel("Session Name:")); add(sessionField);
        add(new JLabel("")); add(nextBtn);

        nextBtn.addActionListener(e -> {
            User u = new User(userField.getText(), schoolField.getText(), sessionField.getText());
            if (u.isValid()) {
                controller.setUser(u);
                frame.showPanel("2");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields before proceeding.");
            }
        });
    }
}