import java.util.Stack;

public class Utility {
    public boolean isOperator(char value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    public boolean isNumber(char value) {
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

    public boolean isOP1HigherInPresedence(char op1, char op2) {
        if(op1 == '+' && op2 == '-') {
            return true;
        }

        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-') ) {
            return true;
        }

        return false;
    }
}
