import java.util.Stack;

public class Task {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                // If the character is a digit, push it onto the stack
                stack.push(Character.getNumericValue(c));
            } else {
                // If the character is an operator, pop operands from the stack, perform the operation, and push the result back
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        // The final result should be on the top of the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "231*+9-";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result of postfix expression \"" + postfixExpression + "\" is: " + result);
    }
}
