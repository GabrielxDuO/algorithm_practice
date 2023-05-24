import java.io.*;

public class _小王子问题_双向链表 {
    static class Node {
        int val;
        Node prev, next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        Node head = new Node(1), curr = head;
        for (int i = 2; i <= 10; ++i) {
            Node node = new Node(i);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        in.nextToken();
        int M = (int) in.nval;
        while (M-- > 0) {
            in.nextToken();
            int X = (int) in.nval;
            curr = head;
            int count = 1;
            while (curr != null) {
                if (curr.val == X) {
                    System.out.println(X);
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    head.prev = curr;
                    curr.next = head;
                    head = curr;
                    break;
                }
                curr = curr.next;
                ++count;
            }
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}