import java.io.*;
import java.util.*;

public class J_青蛙过河 {
    static int n, x;
    static int[] s;
    
    static boolean check(int m) {
        for (int i = 1; i <= n - m; ++i) {
            if (s[i + m - 1] - s[i - 1] < x * 2) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        x = (int) in.nval;
        s = new int[n];
        for (int i = 1; i < n; ++i) {
            in.nextToken();
            s[i] = s[i - 1] + (int) in.nval;
        }
        int l = 1, r = n;
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        System.out.println(l);
    }
}