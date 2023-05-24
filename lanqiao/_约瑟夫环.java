import java.util.*;
import java.io.*;

public class _约瑟夫环 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt(), m = in.nextInt();
        k %= n;
        Queue<Integer> que = new LinkedList<>();
        for (int i = k; i <= n; ++i) que.offer(i);
        for (int i = 1; i < k; ++i) que.offer(i);
        while (!que.isEmpty()) {
            int x = m % que.size();
            if (x == 0) x = que.size();
            while (--x > 0) que.offer(que.poll());
            System.out.println(que.poll());
        }
    }
}
