import java.util.*;
import java.io.*;

public class _乘积尾零 {
    static int cnt2(int x) {
        int res = 0;
        while (x % 2 == 0) {
            ++res;
            x /= 2;
        }
        return res;
    }

    static int cnt5(int x) {
        int res = 0;
        while (x % 5 == 0) {
            ++res;
            x /= 5;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = 100;
        int c2 = 0, c5 = 0;
        while (t-- > 0) {
            int n = in.nextInt();
            c2 += cnt2(n);
            c5 += cnt5(n);
        }
        System.out.println(Math.min(c2, c5));
    }
}
