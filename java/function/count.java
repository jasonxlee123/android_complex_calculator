package function;
import android.util.Log;

import java.math.BigDecimal;
import java.util.Stack;

public class count {
    private int scale; // 进行除法出现无线循环小数时保留的精度

    /** Num stack：save each numbers in the expression */
    private Stack<BigDecimal> numberStack = null;
    /** Symbol stack：save all symbols */
    private Stack<Character> symbolStack = null;

    public count(int scale) {
        super();
        this.scale = scale;
    }

    public count() {
        this(32);
    }

    /**
     * analyze expression with brackets and priority
     *
     * @param numStr
     *            expression with brackets
     */
    public String calculate(String numStr) {
        numStr = removeStrSpace(numStr); // clean space
        // add = as the end sign
        if (numStr.length() > 1
                && !"=".equals(numStr.charAt(numStr.length() - 1) + "")) {
            numStr += "=";
        }
        // check the expression
        if (!isStandard(numStr)) {
            Log.d("cal","Expression Error");
            return "ERROR";
        }
        // initialize stack
        if (numberStack == null) {
            numberStack = new Stack<BigDecimal>();
        }
        numberStack.clear();
        if (symbolStack == null) {
            symbolStack = new Stack<Character>();
        }
        symbolStack.clear();
        // cache the numbers with multiple
        StringBuffer temp = new StringBuffer();
        // start at the first char of the expression
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i); // get a char
            if (isNumber(ch)) { // judge for num
                temp.append(ch); // send to num cache
            } else { // anti-num
                String tempStr = temp.toString(); // num to string in cache
                if (!tempStr.isEmpty()) {
                    // long num = Long.parseLong(tempStr); // num to long int
                    BigDecimal num = new BigDecimal(tempStr);
                    numberStack.push(num); // push num into stack
                    temp = new StringBuffer(); // reset the num buffer
                }
                // judge the priority of the symbol higher cal first
                while (!comparePri(ch) && !symbolStack.empty()) {
                    BigDecimal b = numberStack.pop(); // pop num LIFO
                    BigDecimal a = numberStack.pop();
                    // pop symbol for cal and push the res for next time
                    switch ((char) symbolStack.pop()) {
                        case '+':
                            numberStack.push(a.add(b));
                            break;
                        case '-':
                            numberStack.push(a.subtract(b));
                            break;
                        case '*':
                            numberStack.push(a.multiply(b));
                            break;
                        case '/':
                            try {
                                numberStack.push(a.divide(b));
                            } catch (java.lang.ArithmeticException e) {
                                // division trap into endless loop, reset the num
                                numberStack.push(a.divide(b, this.scale,
                                        BigDecimal.ROUND_HALF_EVEN));
                            }
                            break;
                        default:
                            break;
                    }
                } // while
                if (ch != '=') {
                    symbolStack.push(new Character(ch)); // push symbol
                    if (ch == ')') { // pop the ) bracket
                        symbolStack.pop();
                        symbolStack.pop();
                    }
                }
            }
        } // for

        return String.format("%.3f",numberStack.pop()); // return the result
    }

    /**
     * clean space
     */
    private String removeStrSpace(String str) {
        return str != null ? str.replaceAll(" ", "") : "";
    }

    /**
     * judge legality of expression, true for fine
     */
    private boolean isStandard(String numStr) {
        if (numStr == null || numStr.isEmpty()) // vacancy is illegal
            return false;
        Stack<Character> stack = new Stack<Character>(); // save brackets
        boolean b = false; // mark rest =
        for (int i = 0; i < numStr.length(); i++) {
            char n = numStr.charAt(i);
            // judge the legality for each symbol
            if (!(isNumber(n) || "(".equals(n + "") || ")".equals(n + "")
                    || "+".equals(n + "") || "-".equals(n + "")
                    || "*".equals(n + "") || "/".equals(n + "") || "=".equals(n
                    + ""))) {
                return false;
            }
            // push ( for get ) later
            if ("(".equals(n + "")) {
                stack.push(n);
            }
            if (")".equals(n + "")) { // match the brackets
                if (stack.isEmpty() || !"(".equals((char) stack.pop() + "")) // judge brackets
                    return false;
            }
            // judge the num of =
            if ("=".equals(n + "")) {
                if (b)
                    return false;
                b = true;
            }
        }
        // lack ) return false
        if (!stack.isEmpty())
            return false;
        // = must at the last
        if (!("=".equals(numStr.charAt(numStr.length() - 1) + "")))
            return false;
        return true;
    }

    /**
     * check for all numbers in ask-ii
     */
    private boolean isNumber(char num) {
        if ((num >= '0' && num <= '9') || num == '.')
            return true;
        return false;
    }

    /**
     * compare the priority of symbol with top of stack higher for true
     */
    private boolean comparePri(char symbol) {
        if (symbolStack.empty()) { // empty stack for true
            return true;
        }

        // symbols priority
        // level 1: (
        // level 2: * /
        // level 3: + -
        // level 4: )

        char top = (char) symbolStack.peek(); // read the top object of stack
        if (top == '(') {
            return true;
        }
        // compare priority
        switch (symbol) {
            case '(': // highest
                return true;
            case '*': {
                if (top == '+' || top == '-') // higher than + -
                    return true;
                else
                    return false;
            }
            case '/': {
                if (top == '+' || top == '-') // higher than + -
                    return true;
                else
                    return false;
            }
            case '+':
                return false;
            case '-':
                return false;
            case ')': // lowest priority
                return false;
            case '=': // end sign
                return false;
            default:
                break;
        }
        return true;
    }
}
