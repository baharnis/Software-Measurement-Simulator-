public class Metric {
    private String name;
    private int coefficient;
    private String direction;
    private double min, max, value, score;

    public Metric(String name, int coef, String dir, double min, double max, String unit) {}
    public double calculateScore() { return 0.0; }
}