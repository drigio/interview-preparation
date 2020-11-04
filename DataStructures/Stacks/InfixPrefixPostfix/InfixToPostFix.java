package InfixPrefixPostfix;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String args[]) {
        String expr = "A+B+C+D";
        String res = infixToPostfix(expr);
        System.out.println(res);
    }

    public static String infixToPostfix(String expr) {

        String arr[] = expr.split("");
        String res = "";
        Stack<String> op = new Stack<String>();

        for (String s : arr) {
            if (isOperator(s)) {
                if (s.equals(")")) {
                    while (!op.isEmpty() && !op.peek().equals("(")) {
                        res += op.pop();
                    }
                    op.pop();
                    continue;
                }
                if (s.equals("(")) {
                    op.push(s);
                    continue;
                }
                if (!op.isEmpty() && precedence(op.peek()) <= precedence(s)) {
                    while (!op.isEmpty() && precedence(op.peek()) <= precedence(s)) {
                        res += op.pop();
                    }
                }
                op.push(s);
            } else {
                res += s;
            }
        }
        while (!op.isEmpty())
            res += op.pop();
        return res;
    }

    public static boolean isOperator(String s) {
        return s.matches("[\\^\\/\\*\\+\\-\\(\\)]");
    }

    public static int precedence(String s) {
        switch (s) {
            case "^":
                return 0;
            case "/":
            case "*":
                return 1;
            case "+":
            case "-":
                return 2;
        }
        return 999;
    }

}
