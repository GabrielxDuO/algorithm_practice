import java.util.*;
import java.io.*;

public class _重复字符串 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); int k = (int) in.nval;
        char[] s = br.readLine().toCharArray();
        int n = s.length, len = n / k;
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            int[] cnts = new int[26];
            int mx = 0;
            for (int j = i; j < n; j += len) {
                mx = Math.max(mx, ++cnts[s[j] - 'a']);
            }
            ans += k - mx;
        }
        System.out.println(ans);
    }
}
