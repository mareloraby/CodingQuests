// In an interview you can generally omit the import statements,
// however if you decide to use some library (like Stack in this example)
// it's a good idea to mention it to the Interviewer and ask if it's allowed.
import java.util.Stack;

public class BalancedParentheses {
    public static int longestBalanced(String str) {

        Stack stack = new Stack<Integer>();
        int distance = 0;
        int max = 0;

        for (int i =0; i<str.length(); i++){
            if (str.charAt(i) == '('){
                stack.push(i);

            }
            else
            {
                if (!stack.isEmpty()){

                    int opened = (Integer) stack.pop();
                    distance = i - opened +1;
                    max = Math.max(distance,max);
                }
            }

        }

        return max;
    }

}