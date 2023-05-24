import java.util.*;
import java.io.*;

public class _美丽区间 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int s = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        int l = 0, r = 0, sum = 0, mn = Integer.MAX_VALUE;
        while (r < n) {
            sum += a[r++];
            while (sum >= s) {
                mn = Math.min(mn, r - l);
                sum -= a[l++];
            }
        }
        System.out.println(mn > n ? 0 : mn);
    }
}
