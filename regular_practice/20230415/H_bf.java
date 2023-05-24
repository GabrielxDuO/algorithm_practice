import java.util.*;
import java.io.*;

public class H_bf {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long t = in.nextLong();
        String str = in.next();
        char[] chs = str.toCharArray();
        int[] s = new int[n];
        for (int i = 0; i < n; ++i) {
            if (!flag && chs[i] == '1') {
                hi = n - i;
                flag = true;
            }
            
        }
        while (t-- > 0) {
            for (int i = n - 1; i >= 1; --i) {
                s[i] ^= s[i - 1];
            }
        }
        for (int i = 0; i < n; ++i) System.out.print(s[i]);
        System.out.println();
    }
}
