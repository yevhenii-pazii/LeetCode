import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Interview {
    static class Node {
        int number;
        Node left;
        Node right;

        public Node(int number) {
            this.number = number;
        }

        public Node(int number, Node left, Node right) {
            this.number = number;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    '}';
        }
    }

    /*
         Find nodes visible from the left side. I.E. first lift node for each level
     */
    public static void main(String[] args) {
        System.out.println(leftSide(
                new Node(4,
                        new Node(5,
                                new Node(8),
                                null),
                        new Node(2,
                                new Node(3,
                                        new Node(6),
                                        new Node(7)),
                                new Node(1)))
        ));

        System.out.println(leftSide(
                new Node(1,
                        new Node(2,
                                null,
                                new Node(4,
                                        null, new Node(5))),
                        new Node(3))
        ));

        System.out.println(leftSide(
                new Node(4,
                        new Node(5),
                        new Node(2,
                                new Node(3,
                                        new Node(6),
                                        new Node(7)),
                                new Node(1)))
        ));

        System.out.println();

        System.out.println(leftSideFlat(
                new Node(4,
                        new Node(5,
                                new Node(8),
                                null),
                        new Node(2,
                                new Node(3,
                                        new Node(6),
                                        new Node(7)),
                                new Node(1)))
        ));

        System.out.println(leftSideFlat(
                new Node(1,
                        new Node(2,
                                null,
                                new Node(4,
                                        null, new Node(5))),
                        new Node(3))
        ));

        System.out.println(leftSideFlat(
                new Node(4,
                        new Node(5),
                        new Node(2,
                                new Node(3,
                                        new Node(6),
                                        new Node(7)),
                                new Node(1)))
        ));
    }

    static List<Integer> leftSide(Node root) {
        List<Integer> visibleNodes = new LinkedList<>();
        leftSideRecursion(root, 0, visibleNodes);
        return visibleNodes;
    }

    static void leftSideRecursion(Node node, int level, List<Integer> visibleNodes) {
        if (node == null) return;

        if (visibleNodes.size() == level) {
            visibleNodes.add(node.number);
        }

        leftSideRecursion(node.left, ++level, visibleNodes);
        leftSideRecursion(node.right, level, visibleNodes);
    }


    static List<Integer> leftSideFlat(Node root) {
        List<Integer> visibleNodes = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var levelLength = queue.size();
            visibleNodes.add(queue.peek().number);
            for (var i = 0; i < levelLength; i++) {
                var node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return visibleNodes;
    }
}
