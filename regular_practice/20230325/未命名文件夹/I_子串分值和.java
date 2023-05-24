import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = ('\0' + in.readLine()).toCharArray();
        int n = s.length;
        int[] prevs = new int[26];
        long ans = 0L;
        for (int i = 1; i < n; ++i) {
            ans += (long) (i - prevs[s[i] - 'a']) * (n - i);
            prevs[s[i] - 'a'] = i;
        }
        System.out.println(ans);
    }
}