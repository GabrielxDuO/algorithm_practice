import java.util.*;
import java.io.*;

public class _合并果子 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Queue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            in.nextToken();
            int x = (int) in.nval;
            pq.offer(x);
        }
        int ans = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            ans += sum;
            pq.offer(sum);
        }
        System.out.println(ans);
    }
}
