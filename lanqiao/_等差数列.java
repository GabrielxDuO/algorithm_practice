import java.util.*;
import java.io.*;

public class _等差数列 {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        Arrays.sort(a);
        int d = 0;
        for (int i = 1; i < n; ++i) d = gcd(d, a[i] - a[i - 1]);
        if (a[0] == a[n - 1]) System.out.println(n);
        else System.out.println((a[n - 1] - a[0]) / d + 1);
    }
}
