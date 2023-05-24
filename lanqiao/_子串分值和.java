import java.util.*;
import java.io.*;

public class _子串分值和 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = ('0' + in.readLine()).toCharArray();
        int n = s.length - 1;
        int[] prevs = new int[26];
        long ans = 0L;
        for (int i = 1; i <= n; ++i) {
            int curr = s[i] - 'a';
            ans += 1L * (i - prevs[curr]) * (n - i + 1);
            prevs[curr] = i;
        }
        System.out.println(ans);
    }
}
