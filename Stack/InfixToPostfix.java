import java.util.Stack;

public class InfixToPostfix{
    int precendence(char ch){
        // setting priorities, returning priority levels.
        if(ch=='^'){
            return 3;
        }
        if(ch=='*' || ch == '/' ){
            return 2;
        }
        if(ch=='+' || ch=='-'){
            return 1;
        }
        return -1; // priority doesn't exist

    }


    String infixToPostfix(String exp){

        Stack<Character> stk = new Stack<>();
        String result = ""; // postfix expression

        for(int i=0; i<exp.length();i++){
            char ch = exp.charAt(i);
            if(precendence(ch)>0){
                // it is an operator because 1-3 are operators
                while (!stk.isEmpty() && precendence(ch)<=precendence(stk.peek())){
                    // if stack empty haina bhane and stack peek's operator >
                    result = result+stk.pop();
                }
                    stk.push(ch); // pushing into the stack

            }
            else if(ch=='('){
                stk.push(ch);
            }

            else if(ch==')'){
                char x = stk.pop();
                while(x!='('){    // while x is not equal to '(':  until we meet an opening bracket via the loop, it keeps popping
                    result = result + x;
                    x = stk.pop();
                }
            }
            else{ // operands
                result = result + ch;
        }
    }
        while(!stk.isEmpty()){
            result = result + stk.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        InfixToPostfix o = new InfixToPostfix();
        System.out.println(o.infixToPostfix("5+(3*2)"));
    }
}