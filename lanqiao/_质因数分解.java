import java.util.*;
import java.io.*;

public class _质因数分解 {
    static int pf(int n) {
        int a = -1, b = -1;
        for (int x = 2; x <= n; ++x) {
            if (n % x == 0) {
                n /= x;
                if (a == -1) a = x;
                else b = x;
            }
        }
        if (n > 1) b = n;
        return Math.max(a, b);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(pf(n));
    }
}
