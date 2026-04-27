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

            Dimension d1 = new Dimension("Usability", 40);
            d1.addMetric(new Metric("Response Time", 60, "Lower", 0, 10, "sec"));
            d1.addMetric(new Metric("Success Rate", 40, "Higher", 0, 100, "%"));
            scenario.addDimension(d1);


            Dimension d2 = new Dimension("Performance", 30);
            d2.addMetric(new Metric("CPU Usage", 50, "Lower", 0, 100, "%"));
            d2.addMetric(new Metric("Memory Leak", 50, "Lower", 0, 500, "MB"));
            scenario.addDimension(d2);


            Dimension d3 = new Dimension("Reliability", 30);
            d3.addMetric(new Metric("Uptime", 100, "Higher", 90, 100, "%"));
            scenario.addDimension(d3);

        } else {

            Dimension d1 = new Dimension("Process Efficiency", 40);
            d1.addMetric(new Metric("Defect Density", 70, "Lower", 0, 5, "errors"));
            d1.addMetric(new Metric("Schedule Variance", 30, "Lower", 0, 20, "%"));
            scenario.addDimension(d1);


            Dimension d2 = new Dimension("Maintainability", 30);
            d2.addMetric(new Metric("Code Review Time", 100, "Lower", 0, 48, "hours"));
            scenario.addDimension(d2);


            Dimension d3 = new Dimension("Resource Use", 30);
            d3.addMetric(new Metric("Budget Overrun", 100, "Lower", 0, 5000, "$"));
            scenario.addDimension(d3);
        }
    }
}