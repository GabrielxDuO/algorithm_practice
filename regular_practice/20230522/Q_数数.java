import java.util.*;
import java.io.*;

public class Q_数数 {
    static boolean check(int n) {
        int cnt = 0;
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) {
                while (n % x == 0) {
                    n /= x;
                    if (++cnt > 12) return false;
                }
            }
        }
        if (n > 1) ++cnt;
        return cnt == 12;
    }

    public static void main(String[] args) throws IOException {
        // int cnt = 0;
        // for (int i = 2333333; i <= 23333333; ++i) {
        //     if (check(i)) ++cnt;
        // }
        // System.out.println(cnt); // 25606
        System.out.println(25606);
    }
}
