public class MeasurementController {
    private User user;
    private Scenario scenario;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void initializeScenario(String mode, String type) {
        scenario = new Scenario("Analysis Scenario", mode, type);

        if (type.equals("Product Quality")) {
            Dimension d1 = new Dimension("Usability", 50);
            d1.addMetric(new Metric("Response Time", 60, "Lower", 0, 10, "sec"));
            d1.addMetric(new Metric("Success Rate", 40, "Higher", 0, 100, "%"));
            scenario.addDimension(d1);
        } else {
            Dimension d1 = new Dimension("Process Efficiency", 50);
            d1.addMetric(new Metric("Defect Density", 70, "Lower", 0, 5, "errors"));
            d1.addMetric(new Metric("Schedule Variance", 30, "Lower", 0, 20, "%"));
            scenario.addDimension(d1);
        }
    }
}