public class Metric {
    private String name;
    private int coefficient;
    private String direction;
    private double min;
    private double max;
    private String unit;
    private double value;

    public Metric(String name, int coefficient, String direction, double min, double max, String unit) {
        this.name = name;
        this.coefficient = coefficient;
        this.direction = direction;
        this.min = min;
        this.max = max;
        this.unit = unit;
    }

    public void setValue(double value) { this.value = value; }
    public double getValue() { return value; }
    public String getName() { return name; }
    public int getCoefficient() { return coefficient; }
    public String getDirection() { return direction; }
    public String getUnit() { return unit; }
    public double getMin() { return min; }
    public double getMax() { return max; }

    public double calculateScore() {
        double score;
        if (direction.contains("Higher")) {
            score = 1 + (value - min) / (max - min) * 4;
        } else {
            score = 5 - (value - min) / (max - min) * 4;
        }
        score = Math.round(score * 2) / 2.0;
        return Math.max(1.0, Math.min(5.0, score));
    }
}