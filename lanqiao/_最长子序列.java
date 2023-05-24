import java.util.*;
import java.io.*;

public class _最长子序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();
        char[] t = in.readLine().toCharArray();
        int n = s.length, m = t.length, cnt = 0;
        for (int i = 0, j = 0; i < n && j < m; ++i) {
            if (s[i] == t[j]) {
                ++j;
                ++cnt;
            }
        }
        System.out.println(cnt);
    }
}
