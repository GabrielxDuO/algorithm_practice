import java.io.*;

public class _约瑟夫环问题_循环链表 {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int K = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;
        Node head = new Node(1), curr = head;
        Node beforeStart = null;
        for (int i = 2; i <= N; ++i) {
            curr.next = new Node(i);
            curr = curr.next;
            if (i == K - 1) beforeStart = curr;
        }
        curr.next = head;
        if (beforeStart == null) beforeStart = curr;
        while (beforeStart.next != beforeStart) {
            for (int count = 1; count < M; ++count) {
                beforeStart = beforeStart.next;
            }
            System.out.println(beforeStart.next.val);
            beforeStart.next = beforeStart.next.next;
        }
        System.out.println(curr.val);
    }
}