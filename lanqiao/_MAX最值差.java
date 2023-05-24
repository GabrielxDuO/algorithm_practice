import java.util.*;
import java.io.*;

public class _MAX最值差 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        // n = [4, 6, 5, 2, 3, 1]6, k = 3
        // 1: min([max(1, -2), 1]) max([max(1, -2), 1]);   max(1..1) - min(1..1)
        // 2: min([max(1, -1), 2]) max([max(1, -1), 2]);   max(1..2) - min(1..2)
        // 3: min([max(1, 0), 3]) max([max(1, 0), 3]);     max(1..3) - min(1..3)
        // 4: min([max(1, 1), 4]) max([max(1, 1), 4]);     max(1..4) - min(1..4)
        // 5: min([max(1, 2), 5]) max([max(1, 2), 5]);     max(2..5) - min(2..5)
        // 6: min([max(1, 3), 6]) max([max(1, 3), 6]);     max(3..6) - min(3..6)
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        int[] que1 = new int[n], que2 = new int[n];
        int h1 = 0, t1 = -1, h2 = 0, t2 = -1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (h1 <= t1 && i - que1[h1] > k) ++h1;
            while (h1 <= t1 && a[que1[t1]] >= a[i]) --t1;
            if (h2 <= t2 && i - que2[h2] > k) ++h2;
            while (h2 <= t2 && a[que2[t2]] <= a[i]) --t2;
            que1[++t1] = i;
            que2[++t2] = i;
            ans = Math.max(ans, a[que2[h2]] - a[que1[h1]]);
        }
        System.out.println(ans);
    }
}
