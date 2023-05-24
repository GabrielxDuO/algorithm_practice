import java.util.*;
import java.io.*;

public class _小明的字符串 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();
        char[] t = in.readLine().toCharArray();
        int n = s.length, m = t.length;
        int currLen = 0, max = 0;
        for (int i = 0, j = 0; i < n && j < m; ++i, ++j) {
            if (s[i] == t[j]) max = Math.max(j + 1, currLen);
            else {
                currLen = 0;
                j = 0;
            }
        }
        System.out.println(max);
    }
}
