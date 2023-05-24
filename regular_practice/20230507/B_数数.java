import java.util.*;
import java.io.*;

public class B_数数 {
    static int pf(int n) {
        int cnt = 0;
        for (int x = 2; x <= n / x; ++x) {
            while (n % x == 0) {
                n /= x;
                ++cnt;
            }
        }
        if (n > 1) ++cnt;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // int cnt = 0;
        // for (int x = 2333333; x <= 23333333; ++x) {
        //     if (pf(x) == 12) ++cnt;
        // }
        // System.out.println(cnt);
        System.out.println(25606);
    }
}
