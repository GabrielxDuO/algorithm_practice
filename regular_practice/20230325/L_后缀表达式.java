import java.util.*;
import java.io.*;

public class L_后缀表达式 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int len = n + m + 1;
        int[] a = new int[len];
        for (int i = 0; i < len; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        long ans = 0;
        if (m == 0) {
            for (int x : a) ans += x;
        } else {
            Arrays.sort(a);
            ans = a[len - 1] - a[0];
            for (int i = 1; i < len - 1; ++i) ans += Math.abs(a[i]);
        }
        System.out.println(ans);
    }
}
