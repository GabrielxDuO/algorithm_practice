import java.util.*;
import java.io.*;
import java.math.*;

public class _1113 {
    static final int N = (int) 1e5 + 10;
    static char[] ans = new char[N];

    static int conv(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        else return c - 'a' + 10;
    }

    static char conv(int x) {
        if (x <= 9) return (char) (x + '0');
        else return (char) (x - 10 + 'a');
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int n = a.length, m = b.length;
        int rem = 0;
        int i = n - 1, j = m - 1, k = 0;
        for (; i >= 0 && j >= 0; --i, --j) {
            int x = conv(a[i]), y = conv(b[j]);
            int sum = x + y + rem;
            rem = sum / 30;
            sum %= 30;
            ans[k++] = conv(sum);
        }
        while (i >= 0) {
            int sum = rem + conv(a[i--]);
            rem = sum / 30;
            sum %= 30;
            ans[k++] = conv(sum);
        }
        while (j >= 0) {
            int sum = rem + conv(b[j--]);
            rem = sum / 30;
            sum %= 30;
            ans[k++] = conv(sum);
        }
        if (rem > 0) ans[k++] = conv(rem);
        while (k - 1 >= 0 && ans[k - 1] == '0') --k;
        if (k == 0) ++k;
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) sb.append(ans[k]);
        out.println(sb);
        out.flush();
        out.close();
    }
}
