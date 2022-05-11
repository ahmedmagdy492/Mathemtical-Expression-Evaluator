import java.util.ArrayList;
import java.util.Stack;

public class NumberExtractor {
    public ArrayList<Float> extractNumbers(String exp) {
        ArrayList<Float> expressions = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        // 12+65*56

        for(int i = 0;i < exp.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(exp.charAt(i));
            }
            else {
                char lastElement = stack.peek();

                if( (isOperator(lastElement) || isNumber(lastElement)) && isNumber(exp.charAt(i))) {
                    stack.push(exp.charAt(i));
                }
                else if(Character.isDigit(lastElement) && isOperator(exp.charAt(i))) {
                    String elements = popStack(stack);

                    expressions.add(Float.parseFloat(reverseString(elements)));
                    expressions.add((float)exp.charAt(i));
                }
            }
        }

        String lastNumber = reverseString(popStack(stack));
        expressions.add(Float.parseFloat(lastNumber));

        return expressions;
    }

    private boolean isOperator(char value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    private boolean isNumber(char value) {
        String validChars = "0123456789.";

        return validChars.contains(value + "");
    }

    // returns the number in the reversed order
    public String popStack(Stack<Character> stack) {
        StringBuilder finalValue = new StringBuilder();

        while(!stack.isEmpty()) {
            finalValue.append(stack.pop());
        }

        return finalValue.toString();
    }

    public String reverseString(String str) {
        StringBuilder temp = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--) {
            temp.append(str.charAt(i));
        }

        return temp.toString();
    }
}
