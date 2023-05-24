import java.util.*;
import java.io.*;

public class _G {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(a);
        for (int i = 1; i < n; ++i) min = Math.min(min, a[i] - a[i - 1]);
        System.out.println((a[n - 1] - a[0]) / min + 1);
    }
}
