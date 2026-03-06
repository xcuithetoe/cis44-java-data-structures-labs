public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // Implement this method using a Stack.
        Stack<Character> buffer = new ArrayStack<>(line.length());

        // opening and closing symbols (I'll use these later for identification)
        final String opening = "({[";
        final String closing = ")}]";

        // add all the characters of the line into the stack

        for (char c : line.toCharArray()) {
            if (opening.indexOf(c) != -1) { // c is an opening symbol
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) { // c is a closing symbol
                if (buffer.isEmpty()) {
                    return false; // symbols must be imbalanced
                } else if (closing.indexOf(buffer.pop()) != opening.indexOf(c)) { 
                    // if there is a symbol, check if it balances with opening symbol. ie, { and }
                    return false;
                }
            }
        }
        // finally, if stack is empty, then the line is balanced!
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
} 

