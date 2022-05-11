import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        NumberExtractor numberExtractor = new NumberExtractor();
        ArrayList<Float> values = numberExtractor.extractNumbers("-12.25+5.6*80.5");

        for(Float value : values) {
            System.out.println(value);
        }
    }
}