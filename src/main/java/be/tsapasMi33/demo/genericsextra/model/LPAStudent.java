package be.tsapasMi33.demo.genericsextra.model;

public class LPAStudent extends Student {
    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentcomplete")){
            return percentComplete <= Integer.parseInt(value);
        }
        return super.matchFieldValue(fieldName, value);
    }
}
