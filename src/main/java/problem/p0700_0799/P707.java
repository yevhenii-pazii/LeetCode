package problem.p0700_0799;

class P707 {

    public static void main(String[] args) {
        var mll = new MyLinkedListV3();
        mll.addAtHead(4);
        mll.addAtHead(1);
        mll.addAtTail(5);
//        mll.get(1);
//        mll.deleteAtIndex(1);
//
//
//        mll.addAtTail(3);
//        mll.addAtIndex(1, 2);
//        mll.get(1);

        System.out.println(mll);

//          Your MyLinkedList object will be instantiated and called as such:
//          MyLinkedList obj = new MyLinkedList();
//          int param_1 = obj.get(index);
//          obj.addAtHead(val);
//          obj.addAtTail(val);
//          obj.addAtIndex(index,val);
//          obj.deleteAtIndex(index);
    }

    static class MyLinkedList {

        private static class Node {
            private final int value;
            private Node next;
            private Node previous;

            private Node(int value) {
                this(value, null, null);
            }

            private Node(int value, Node next, Node previous) {
                this.value = value;
                this.next = next;
                this.previous = previous;
            }

            public int getValue() {
                return value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getPrevious() {
                return previous;
            }

            public void setPrevious(Node previous) {
                this.previous = previous;
            }

            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }

        private int size = 0;
        private Node head = null;
        private Node tail = null;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return getNodeAt(index).getValue();
        }

        private Node getNodeAt(int index) {
            Node node;
            if (size / 2 <= index) {
                node = head;
                for (var i = 0; i < index; i++) {
                    node = node.getNext();
                }

            } else {
                node = tail;
                for (var i = size - 1; i > index; i--) {
                    node = node.getPrevious();
                }
            }

            return node;
        }

        public void addAtHead(int val) {
            size++;
            if (head == null) {
                tail = head = new Node(val);
            } else {
                head = new Node(val, head, null);
                head.getNext().setPrevious(head);
            }
        }

        public void addAtTail(int val) {
            size++;
            if (tail == null) {
                head = tail = new Node(val);
            } else {
                tail.setNext(new Node(val, null, tail));
                tail = tail.getNext();
            }
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                var newNode = new Node(val, getNodeAt(index), null);
                newNode.setPrevious(newNode.getNext().getPrevious());
                newNode.getPrevious().setNext(newNode);
                newNode.getNext().setPrevious(newNode);
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else if (index == 0) {
                    head = head.getNext();
                    head.setPrevious(null);
                } else if (index == size - 1) {
                    tail = tail.getPrevious();
                    tail.setNext(null);
                } else {
                    var node = getNodeAt(index);
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                }
                size--;
            }
        }

        @Override
        public String toString() {
            var builder = new StringBuilder();
            builder.append('[');

            var node = head;
            while (node != null) {
                builder.append(node.getValue());
                builder.append(',');
                node = node.getNext();
            }

            if (size > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(']');
            return builder.toString();
        }
    }

    static class MyLinkedListV2 {

        private static class Node {
            private final int value;
            private Node next;
            private Node previous;

            private Node(int value) {
                this(value, null, null);
            }

            private Node(int value, Node next, Node previous) {
                this.value = value;
                this.next = next;
                this.previous = previous;
            }

            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }

        private int size = 0;
        private Node head = new Node(0);
        private Node tail = new Node(-1);

        public MyLinkedListV2() {
            head.next = tail;
            head.previous = head; // is needed?
            tail.previous = head;
            tail.next = tail; // is needed?
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return getNodeAt(index).value;
        }

        private Node getNodeAt(int index) {
            Node node;
            if (size / 2 <= index) {
                node = head;
                for (var i = 0; i <= index; i++) {
                    node = node.next;
                }
            } else {
                node = tail;
                for (var i = size - 1; i >= index; i--) {
                    node = node.previous;
                }
            }

            return node;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            var newNode = new Node(val, getNodeAt(index), null);
            newNode.previous = newNode.next.previous;
            newNode.previous.next = newNode;
            newNode.next.previous = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                var node = getNodeAt(index);
                node.previous.next = node.next;
                node.next.previous = node.previous;
                size--;
            }
        }

        @Override
        public String toString() {
            var builder = new StringBuilder();
            builder.append('[');

            var node = head.next;
            while (node != tail) {
                builder.append(node.value);
                builder.append(',');
                node = node.next;
            }

            if (size > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(']');
            return builder.toString();
        }
    }

    static class MyLinkedListV3 {

        private static class Node {
            private final int value;
            private Node next;


            private Node(int value) {
                this(value, null);
            }

            private Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }

            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }

        private int size = 0;
        private Node head = new Node(0);
        //private Node tail = new Node(-1);

        public MyLinkedListV3() {
            //head.next = tail;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return getNodeAt(index).value;
        }

        private Node getNodeAt(int index) {
            Node node = head;
            for (var i = 0; i <= index; i++) {
                node = node.next;
            }
            return node;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            var pred = getNodeAt(index - 1);
            pred.next = new Node(val, pred.next);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                var node = getNodeAt(index - 1);
                node.next = node.next.next;
                size--;
            }
        }

        @Override
        public String toString() {
            var builder = new StringBuilder();
            builder.append('[');

            var node = head.next;
            while (node != null) {
                builder.append(node.value);
                builder.append(',');
                node = node.next;
            }

            if (size > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(']');
            return builder.toString();
        }
    }
}
