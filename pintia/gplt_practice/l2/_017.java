import java.io.*;
import java.util.*;

public class _017 {
    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n];
        int hf = n / 2;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        Arrays.sort(a);
        int diff = 0;
        for (int i = 0; i < n; ++i) {
            if (i < hf) diff -= a[i];
            else diff += a[i];
        }
        System.out.printf("Outgoing #: %d\nIntroverted #: %d\nDiff = %d\n", n - hf, hf, diff);
    }
}
