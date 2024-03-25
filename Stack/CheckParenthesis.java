// .length  = access
// .length() = return value

public class CheckParenthesis{

    // exp = "{()}"
    boolean checkBracket(String exp){
        
        String openBrac = "[{(";
        String closeBrac = "]})";

        Stack stk = new Stack(exp.length());      // size of stack == size of the given string through the parameter
        
        for(int i=0; i<exp.length(); i++){
            char bracket = exp.charAt(i);        // i = 0 huda, openBrac ko index = "[" so, bracket gets that bracket
            if(openBrac.indexOf(bracket) >= 0){  // checking if it is opening bracket or not
                // true for opening bracket
                stk.push(bracket);

            }
            else{
                // closing bracket
                int closingBracIndex = closeBrac.indexOf(bracket); // assigning index to bracket
                char corespOpenBrac = openBrac.charAt(closingBracIndex);

                if(stk.pop() != corespOpenBrac){
                    return false;
                }
            }
        }

        if(!stk.isEmpty()){
            return false;
        }


        return true;

    } 


    public static void main(String[] args) {
        
        CheckParenthesis c = new CheckParenthesis();
        System.out.println(c.checkBracket("{()"));
    }

}