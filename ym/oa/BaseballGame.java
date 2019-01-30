import java.util.*;


class BaseballGame {
    public static int calPoints(String[] ops) {
        Stack<Integer> numberStack = new Stack<Integer>();

        for(String op : ops) {
            if (op.equals("+")) {
                if (numberStack.size() < 2) return -1;
                int top = numberStack.pop();
                int newtop = top + numberStack.peek();
                numberStack.push(top);
                numberStack.push(newtop);
            } else if (op.equals("C")) {
                if (numberStack.size() < 1) return -1;
                numberStack.pop();
            } else if (op.equals("D")) {
                if (numberStack.size() < 1) return -1;
                numberStack.push(2 * numberStack.peek());
            } else {
                try {
                    numberStack.push(Integer.valueOf(op));
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        }

        int totalScore = 0;
        for(int score : numberStack) totalScore += score;
        return totalScore;
    }

    public static void main(String[] args){
        String[] input1 = {
                "5","2","C","D","+"
        };
        String[] input2 = {
                "5","-2","4","C","D","9","+","+"
        };
        int res = calPoints(input1);
        System.out.println(res);
    }
}