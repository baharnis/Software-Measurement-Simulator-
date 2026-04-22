public class App {
    public static void main(String[] args) {
        MeasurementController controller = new MeasurementController();
        MainFrame frame = new MainFrame(controller);
        frame.setVisible(true);
    }
}
