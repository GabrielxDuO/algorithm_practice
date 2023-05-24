import java.io.*;

public class _银行排队问题_数组实现队列 {
    static class SimpleQueue {
        String[] elements = new String[1000];
        int front = 0, back = 0;

        public void offer(String val) {
            elements[back++] = val;
        }

        public String poll() {
            return elements[front++];
        }

        public boolean isEmpty() {
            return front == back;
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