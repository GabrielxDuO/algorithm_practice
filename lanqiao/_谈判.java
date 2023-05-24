import java.util.*;
import java.io.*;

public class _谈判 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Queue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            in.nextToken();
            pq.offer((int) in.nval);
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
