import java.util.*;
import java.io.*;

public class _约数个数 {
    static int countDivisors(int n) {
        int cnt = 1;
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) {
                int s = 0;
                while (n % x == 0) {
                    n /= x;
                    ++s;
                }
                cnt *= s + 1;
            }
        }
        if (n > 1) cnt <<= 1;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(countDivisors(1200000));
    }
}
