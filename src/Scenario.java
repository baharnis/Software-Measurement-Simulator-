import java.util.*;

public class Scenario {
    private String name;
    private String mode;
    private String qualityType;
    private List<Dimension> dimensions = new ArrayList<>();

    public Scenario(String name, String mode, String qualityType) {
        this.name = name;
        this.mode = mode;
        this.qualityType = qualityType;
    }

    public void addDimension(Dimension d) {
        dimensions.add(d);
    }

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public String getName() {
        return name;
    }

    public String getQualityType() {
        return qualityType;
    }

    public String getMode() {
        return mode;
    }
}