import java.util.ArrayList;
import java.util.Stack;

public class NumberExtractor {
    public ArrayList<Float> extractNumbers(String exp) {
        ArrayList<Float> expressions = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        Utility utility = new Utility();

        // 12+65*56

        for(int i = 0;i < exp.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(exp.charAt(i));
            }
            else {
                char lastElement = stack.peek();

                if( (utility.isOperator(lastElement) || utility.isNumber(lastElement)) && utility.isNumber(exp.charAt(i))) {
                    stack.push(exp.charAt(i));
                }
                else if(Character.isDigit(lastElement) && utility.isOperator(exp.charAt(i))) {
                    String elements = utility.popStack(stack);

                    expressions.add(Float.parseFloat(utility.reverseString(elements)));
                    expressions.add((float)exp.charAt(i));
                }
            }
        }

        String lastNumber = utility.reverseString(utility.popStack(stack));
        expressions.add(Float.parseFloat(lastNumber));

        return expressions;
    }

    
}
