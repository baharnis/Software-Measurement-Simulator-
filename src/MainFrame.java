import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel container = new JPanel(cardLayout);

    public MainFrame(MeasurementController controller) {
        setTitle("ISO 15939 Measurement Simulator");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        container.add(new ProfilePanel(controller, this), "1");
        container.add(new DefinePanel(controller, this), "2");
        container.add(new PlanPanel(controller, this), "3");
        container.add(new CollectPanel(controller, this), "4");
        container.add(new AnalysePanel(controller), "5");

        add(container);
        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(container, name);
    }
}