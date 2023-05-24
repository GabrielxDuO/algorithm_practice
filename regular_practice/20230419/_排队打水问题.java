import java.util.*;
import java.io.*;

public class _排队打水问题 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int r = (int) in.nval;
        int[] t = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); t[i] = (int) in.nval;
        }
        Arrays.sort(t);
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < r; ++i) pq.offer(0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int curr = pq.poll();
            curr += t[i];
            ans += curr;
            pq.offer(curr);
        }
        System.out.println(ans);
    }
}
