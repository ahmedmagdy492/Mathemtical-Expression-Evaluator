import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        NumberExtractor numberExtractor = new NumberExtractor();
        Evaluator evaluator = new Evaluator();
        // -12.25+5.6*80.5
        ArrayList<Float> values = numberExtractor.extractNumbers("-12.25+5.6*80.5");
        float result = evaluator.eval(values);

        System.out.println(result);
    }
}