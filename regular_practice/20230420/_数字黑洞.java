import java.util.*;
import java.io.*;

public class _数字黑洞 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), cnt = 0;
        while (true) {
            if (n == 6174) {
                System.out.println(cnt);
                return;
            }
            char[] s = Integer.toString(n).toCharArray();
            Arrays.sort(s);
            String ns = String.valueOf(s);
            int mn = Integer.parseInt(ns), mx = Integer.parseInt(new StringBuilder(ns).reverse().toString());
            n = mx - mn;
            ++cnt;
        }
    }
}
