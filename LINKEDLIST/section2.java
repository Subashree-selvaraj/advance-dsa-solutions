import java.util.HashMap;
import java.util.Map;

public class XorLinkedListDemo {

    static class Node {
        int data;
        int npx; //  XOR of previous and next node IDs

        Node(int data) {
            this.data = data;
            this.npx = 0;
        }
    }

    static class XorLinkedList {
        private final Map<Integer, Node> nodes = new HashMap<>();
        private int nextId = 1;
        private int headId = 0;
        private int tailId = 0;

        private int xor(int a, int b) {
            return a ^ b;
        }

        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            int newId = nextId++;

            nodes.put(newId, newNode);

            newNode.npx = xor(0, headId);

            if (headId != 0) {
                Node head = nodes.get(headId);
                int headNext = xor(0, head.npx);
                head.npx = xor(newId, headNext);
            } else {
                tailId = newId;
            }

            headId = newId;
        }

        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            int newId = nextId++;

            nodes.put(newId, newNode);

            if (tailId == 0) {
                newNode.npx = xor(0, 0);
                headId = tailId = newId;
                return;
            }

            Node tail = nodes.get(tailId);
            int tailPrev = xor(0, tail.npx);
            tail.npx = xor(tailPrev, newId);

            newNode.npx = xor(tailId, 0);
            tailId = newId;
        }

        public void traverseForward() {
            int prevId = 0;
            int currId = headId;

            while (currId != 0) {
                Node curr = nodes.get(currId);
                System.out.print(curr.data + " ");

                int nextId = xor(prevId, curr.npx);
                prevId = currId;
                currId = nextId;
            }
            System.out.println();
        }

        public void traverseBackward() {
            int nextId = 0;
            int currId = tailId;

            while (currId != 0) {
                Node curr = nodes.get(currId);
                System.out.print(curr.data + " ");

                int prevId = xor(nextId, curr.npx);
                nextId = currId;
                currId = prevId;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        XorLinkedList list = new XorLinkedList();

        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        list.insertAtEnd(40);
        list.insertAtEnd(50);

        System.out.print("Forward: ");
        list.traverseForward();

        System.out.print("Backward: ");
        list.traverseBackward();
    }
}


// parti_i:
// Two distinct disadvantages of an XOR linked list are:

//1. Debugging becomes difficult.
// Real-time debuggers and memory inspection tools cannot easily follow the list because the links are stored as XOR-combined addresses instead of normal next and prev pointers.

//2. Garbage collection and tracing are harder.
// Automated runtimes like garbage collectors may not recognize XOR-compressed links as valid object references, so tracing live nodes and reclaiming memory safely becomes more complicated.
