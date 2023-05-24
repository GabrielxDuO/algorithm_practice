import java.util.*;
import java.io.*;

public class H_异或变换 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long t = in.nextLong();
        String str = in.next();
        char[] chs = str.toCharArray();
        int[] s = new int[n];
        boolean flag = false;
        int hi = 0;
        for (int i = 0; i < n; ++i) {
            if (!flag && chs[i] == '1') {
                hi = n - i;
                flag = true;
            }
            s[i] = chs[i] - '0';
        }
        if (hi == 0) {
            System.out.println(str);
            return;
        }
        int p = 1;
        while (p < hi) p <<= 1;
        t %= p;
        while (t-- > 0) {
            for (int i = n - 1; i >= 1; --i) {
                s[i] ^= s[i - 1];
            }
        }
        for (int i = 0; i < n; ++i) System.out.print(s[i]);
        System.out.println();
    }
}
