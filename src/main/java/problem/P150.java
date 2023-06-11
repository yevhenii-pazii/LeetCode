package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class P150 {

    /*
        Time Complexity O(N * N)
        Space Complexity O(1)
     */
    public int evalRPNInplace(String[] tokens) {
        var index = 0;
        var length = tokens.length;

        while (index < length) {

            if (tokens[index].length() == 1) {
                if (tokens[index].charAt(0) >= '0') {
                    index++;
                } else {
                    var result = switch (tokens[index]) {
                        case "+" -> Integer.parseInt(tokens[index - 2]) + Integer.parseInt(tokens[index - 1]);
                        case "-" -> Integer.parseInt(tokens[index - 2]) - Integer.parseInt(tokens[index - 1]);
                        case "/" -> Integer.parseInt(tokens[index - 2]) / Integer.parseInt(tokens[index - 1]);
                        case "*" -> Integer.parseInt(tokens[index - 2]) * Integer.parseInt(tokens[index - 1]);
                        default -> throw new RuntimeException();
                    };

                    tokens[index - 2] = Integer.toString(result);

                    length -= 2;
                    index--;
                    for (var i = index; i < length; i++) {
                        tokens[i] = tokens[i + 2];
                    }
                }
            } else {
                index++;
            }
        }


        return Integer.parseInt(tokens[0]);
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int evalRPNStack(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (var s : tokens) {
            try {
                stack.push(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                var op2 = stack.pop();
                var op1 = stack.pop();

                Integer result = switch (s) {
                    case "+" -> op1 + op2;
                    case "-" -> op1 - op2;
                    case "/" -> op1 / op2;
                    case "*" -> op1 * op2;
                    default -> throw new RuntimeException();
                };

                stack.push(result);
            }
        }

        return stack.pop();
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int evalRPNStackV2(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (var s : tokens) {
            Integer result  = switch (s) {
                case "+" -> stack.pop() + stack.pop();
                case "*" -> stack.pop() * stack.pop();
                case "-" -> {
                    var op2 = stack.pop();
                    yield stack.pop() - op2;
                }
                case "/" -> {
                    var op2 = stack.pop();
                    yield stack.pop() / op2;
                }


                default -> Integer.parseInt(s);
            };
            stack.push(result);
        }

        return stack.pop();
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int evalRPNStackV3(String[] tokens) {
        int[] array = new int[tokens.length];
        var index = 0;

        for (var s : tokens) {
            int result = switch (s) {
                case "+" -> array[--index] + array[--index];
                case "*" -> array[--index] * array[--index];
                case "-" -> {
                    var op2 = array[--index];
                    yield array[--index] - op2;
                }
                case "/" -> {
                    var op2 = array[--index];
                    yield array[--index] / op2;
                }

                default -> Integer.parseInt(s);
            };

            array[index++] = result;
        }

        return array[0];
    }
}
