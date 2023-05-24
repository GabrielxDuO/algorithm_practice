import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        Arrays.sort(a);
        int mn = a[n - 1];
        for (int i = 1; i < n; ++i) mn = Math.min(mn, a[i] - a[i - 1]);
        if (mn == 0) {
            System.out.println(n);
            return;
        }
        System.out.println((a[n - 1] - a[0]) / mn + 1);
    }
}
