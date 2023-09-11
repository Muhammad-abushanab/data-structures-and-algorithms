package stack.queue.stack;

public class ValidBracket {
    public boolean validBracket(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '{' || exp.charAt(i) == '(' || exp.charAt(i) == '[') {
                stack.push(exp);
                continue;
            }
            if (stack.isEmpty())
                return false;
            String check;
            switch (exp.charAt(i)) {
                case ')': {
                    check = stack.pop();
                    if (check.equals("{") || check.equals("["))
                        return false;
                }
                break;
                case '}': {
                    check = stack.pop();
                    if (check.equals("(") || check.equals("["))
                        return false;
                }
                break;
                case ']': {
                    check = stack.pop();
                    if (check.equals("{") || check.equals("("))
                        return false;
                }
                break;
            }
        }
        return stack.isEmpty();
    }
}
