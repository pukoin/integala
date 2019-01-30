import java.util.*;


class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> dicStack = new Stack<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                dicStack.push(')');
            else if (ch == '{')
                dicStack.push('}');
            else if (ch == '[')
                dicStack.push(']');
            else if (dicStack.isEmpty() || dicStack.pop() != ch)
                return false;
        }
        return dicStack.isEmpty();
    }

    public static void main(String[] args){
        String input1 = "()";
        String input2 = "(){}[]";
        String input3 = "(]";
        String input4 = "([)]";

        String[] input = {
                "()", "(){}[]", "(]", "([)]"
        };

        for (int i = 0; i < input.length; i++){
            System.out.println(input[i] + ": " + isValid(input[i]));
        }
    }
}