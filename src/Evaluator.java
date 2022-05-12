import java.util.ArrayList;
import java.util.Stack;

public class Evaluator {
    public float eval(ArrayList<Float> numbers) {
        Stack<Float> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();
        Utility utility = new Utility();

        // prepare the 2 stacks
        for(float num : numbers) {
            if(!utility.isOperator((char)num)) {
                // if the current is a number
                nums.push(num);
            }
            else {
                // if the current is an operator
                if(operators.isEmpty()) {
                    operators.push((char)num);
                }
                else {
                    char lastOperator = operators.peek();

                    if(utility.isOP1HigherInPresedence((char)num, lastOperator)) {
                        operators.push((char)num);
                    }
                    else {
                        operators.pop();
                        operators.push((char)num);
                        operators.push(lastOperator);
                    }
                }
            }
        }

        // evaluate the 2 stacks
        while(nums.size() > 1) {
            float fnum = nums.pop();
            float snum = nums.pop();
            char operator = operators.pop();
            nums.push(applyOperation(fnum, snum, operator));
        }

        return nums.pop();
    }

    private float applyOperation(float num1, float num2, char operation) {
        if(operation == '+') {
            return num1 + num2;
        }
        else if(operation == '-') {
            return num1 - num2;
        }
        else if(operation == '*') {
            return num1 * num2;
        }
        else if(operation == '/') {

            if(num2 == 0)
                return 0;

            return num1 / num2;
        }

        return 0;
    }
}