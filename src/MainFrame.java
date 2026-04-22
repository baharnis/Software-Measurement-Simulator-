import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(MeasurementController controller) {
        setTitle("ISO 15939 Simulator");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
