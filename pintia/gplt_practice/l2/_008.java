import java.io.*;

public class _008 {
    static final int N = 1010;
    static char[] s;
    static int n;
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toCharArray();
        n = s.length;
        for (int i = 0; i < n - 1; ++i) {
            extend(i, i);
            extend(i, i + 1);
        }
        System.out.println(ans);
    }

    static void extend(int l, int r) {
        while (l >= 0 && r < n && s[l] == s[r]) {
            --l;
            ++r;
        }
        ans = Math.max(ans, r - l - 1);
    }
}
