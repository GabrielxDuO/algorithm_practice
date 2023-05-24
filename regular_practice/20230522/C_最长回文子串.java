import java.util.*;
import java.io.*;

public class C_最长回文子串 {
    static char[] s;
    static int n, mx;

    static void expend(int l, int r) {
        while (l >= 0 && r < n) {
            if (s[l] == s[r]) {
                --l;
                ++r;
            } else break;
        }
        mx = Math.max(mx, r - l - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        s = in.nextLine().toCharArray();
        n = s.length;
        for (int i = 0; i < n - 1; ++i) {
            expend(i, i);
            expend(i, i + 1);
        }
        System.out.println(mx);
    }
}
