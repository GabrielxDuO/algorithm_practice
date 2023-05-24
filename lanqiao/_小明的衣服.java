import java.util.*;
import java.io.*;

public class _小明的衣服 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Queue<Long> heap = new PriorityQueue<>();
        while (n-- > 0) {
            in.nextToken();
            heap.offer((long) in.nval);
        }
        long ans = 0L;
        while (heap.size() > 1) {
            long sum = heap.poll() + heap.poll();
            ans += sum;
            heap.offer(sum);
        }
        System.out.println(ans);
    }
}
