import java.util.*;
import java.io.*;

public class _最长回文子串 {
    static char[] str;
    static int n;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        str = in.readLine().toCharArray();
        n = str.length - 1;
        for (int i = 0; i < n; ++i) {
            expend(i, i);
            expend(i, i + 1);
        }
        System.out.println(max);
    }

    static void expend(int l, int r) {
        while (l >= 0 && r < n && str[l] == str[r]) {
            --l;
            ++r;
        }
        max = Math.max(max, r - l - 1);
    }
}
