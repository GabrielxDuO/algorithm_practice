import java.util.*;
import java.io.*;

public class _最小乘积 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); int n = (int) in.nval;
            int[] a = new int[n];
            Integer[] b = new Integer[n];
            for (int i = 0; i < n; ++i) {
                in.nextToken(); a[i] = (int) in.nval;
            }
            for (int i = 0; i < n; ++i) {
                in.nextToken(); b[i] = (int) in.nval;
            }
            Arrays.sort(a); Arrays.sort(b, (x, y) -> y - x);
            int ans = 0;
            for (int i = 0; i < n; ++i) ans += a[i] * b[i];
            System.out.println(ans);
        }
    }
}
