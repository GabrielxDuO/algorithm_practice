import java.util.*;
import java.io.*;

public class D_山 {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        outer: for (int i = 10; i < 100000; ++i) {
            int num = i, len = 0;
            int prev = 10, j = 0;
            while (num > 0) {
                int d = num % 10;
                if (prev < d) continue outer;
                prev = d;
                j = j * 10 + d;
                ++len;
                num /= 10;
            }
            long x = 1L * i / 10 * (int) Math.pow(10, len) + j;
            long y = 1L * i * (int) Math.pow(10, len) + j;
            if (x >= 2022 && x <= 2022222022) ++cnt;
            if (y >= 2022 && y <= 2022222022) ++cnt;
        }
        System.out.println(cnt);
    }
}
