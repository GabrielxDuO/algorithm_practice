import java.io.*;
import java.util.*;

public class _小蓝吃糖果 {
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
        long sum = 0;
        for (int i = 0; i < n - 1; ++i) sum += a[i];
        System.out.println(sum >= a[n - 1] - 1 ? "Yes" : "No");
    }
}