import java.io.*;

public class _银行排队问题_数组实现循环队列 {
    static class SimpleQueue {
        String[] elements;
        int capacity, front = 0, back = 0;

        public SimpleQueue() { this(10); }

        public SimpleQueue(int capacity) {
            elements = new String[capacity];
            this.capacity = capacity;
        }

        public boolean offer(String val) {
            if (isFull()) return false;
            elements[back++ % capacity] = val;
            return true;
        }

        public String poll() {
            if (isEmpty()) return "";
            return elements[front++];
        }

        public boolean isEmpty() {
            return front == back;
        }

        public boolean isFull() {
            return back - front == capacity;  
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