import java.util.*;
import java.io.*;

public class _子串分值 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int n = s.length();
        char[] chs = ('0' + s).toCharArray();
        int[] prevs = new int[26];
        long ans = 0L;
        for (int i = 1; i <= n; ++i) {
            int curr = chs[i] - 'a';
            ans += (i - prevs[curr]) * (n - i + 1);
            prevs[curr] = i;
        }
        System.out.println(ans);
    }
}
