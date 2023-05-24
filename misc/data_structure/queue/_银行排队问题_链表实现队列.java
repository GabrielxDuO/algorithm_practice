import java.io.*;

public class _银行排队问题_链表实现队列 {
    static class SimpleQueue {
        static class Node {
            String val;
            Node next;

            public Node() { }
            public Node(String val) { this.val = val; }
        }

        Node dummy = new Node(), back = dummy;

        public void offer(String val) {
            back.next = new Node(val);
            back = back.next;
        }

        public String poll() {
            String val = dummy.next.val;
            dummy.next = dummy.next.next;
            return val;
        }

        public boolean isEmpty() {
            return dummy.next == null;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int M = (int) in.nval;
        SimpleQueue VQueue = new SimpleQueue(), NQueue = new SimpleQueue();
        while (M-- > 0) {
            in.nextToken();
            String ope = in.sval;
            String name = "";
            if (ope.equals("IN")) {
                in.nextToken();
                name = in.sval;
            }
            in.nextToken();
            String type = in.sval;
            SimpleQueue queue = type.charAt(0) == 'V' ? VQueue : NQueue;
            if (ope.equals("IN")) queue.offer(name);
            else queue.poll();
        }
        while (!VQueue.isEmpty()) {
            System.out.println(VQueue.poll());
        }
        while (!NQueue.isEmpty()) {
            System.out.println(NQueue.poll());
        }
    }
}