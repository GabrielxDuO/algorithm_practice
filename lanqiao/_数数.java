import java.util.*;
import java.io.*;

public class _数数 {
    static boolean check(int n) {
        int cnt = 0;
        for (int i = 2; i <= n / i; ++i) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                    ++cnt;
                }
                if (cnt > 12) return false;
            }
        }
        if (n > 1) ++cnt;
        return cnt == 12;
    }

    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 2333333; i <= 23333333; ++i) {
            if (check(i)) ++cnt;
        }
        System.out.println(cnt);
    }
}

// 大概算了35s左右 是可以跑出来的
// public class Main {
//     public static void main(String[] args) {
//         System.out.println(25606);
//     }
// }

