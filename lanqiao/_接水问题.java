import java.util.*;
import java.io.*;

public class _接水问题 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int mx = 0;
        int[] a = new int[n];
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            int x = (int) in.nval;
            a[i] = x;
            mx = Math.max(mx, x);
            if (i < m) pq.offer(x);
        }
        for (int i = m; i < n; ++i) {
            int sum = pq.poll() + a[i];
            mx = Math.max(mx, sum);
            pq.offer(sum);
        }
        System.out.println(mx);
    }
}
