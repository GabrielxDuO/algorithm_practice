import java.util.*;
import java.io.*;

public class _I {
    static final int M = 30000;

    static long solve(long n) {
        if (n == 1L) return 1L;
        long[] prev = new long[M], curr = new long[M];
        prev[0] = prev[1] = curr[0] = curr[1] = 1L;
        int idx = 3, row = 2;
        while (row < 44723) {
            int hf = (++row + 1) / 2;
            ++idx;
            for (int i = 1; i < hf; ++i) {
                ++idx;
                if ((row & 1) != 0 && (i == hf - 1)) curr[i] = prev[i - 1] << 1;
                else curr[i] = prev[i - 1] + prev[i];
                if (curr[i] == n) return idx;
                prev[i - 1] = curr[i - 1];
            }
            idx += row - hf;
            prev[hf - 1] = curr[hf - 1];
            if (curr[1] > n) break;
        }
        // System.out.println("overflow");
        return n * (n + 1) / 2 + 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        System.out.println(solve(n));
        // 人肉二分找分界点 44723
        // for (int i = 1; i <= 100; ++i) System.out.println(i + " - " + solve(i));
        // for (int i = 10000; i <= 10010; ++i) System.out.println(i + " - " + solve(i));
        // for (int i = 100000; i <= 100010; ++i) System.out.println(i + " - " + solve(i)); // of
        // for (int i = 50000; i <= 50010; ++i) System.out.println(i + " - " + solve(i)); // of
        // for (int i = 25000; i <= 25010; ++i) System.out.println(i + " - " + solve(i));
        // for (int i = 37500; i <= 37510; ++i) System.out.println(i + " - " + solve(i));
        // for (int i = 43750; i <= 43760; ++i) System.out.println(i + " - " + solve(i));
        // for (int i = 46875; i <= 46885; ++i) System.out.println(i + " - " + solve(i)); // of
        // System.out.println(43750 + 46875 >> 1);
        // for (int i = 45312; i <= 45322; ++i) System.out.println(i + " - " + solve(i));
        // System.out.println(43750 + 45312 >> 1);
        // for (int i = 44531; i <= 44541; ++i) System.out.println(i + " - " + solve(i));
        // System.out.println(44531 + 45312 >> 1);
        // for (int i = 44921; i <= 44931; ++i) System.out.println(i + " - " + solve(i)); // of
        // System.out.println(44531 + 44921 >> 1);
        // for (int i = 44726; i <= 44736; ++i) System.out.println(i + " - " + solve(i)); // of
        // System.out.println(44531 + 44726 >> 1);
        // for (int i = 44628; i <= 44638; ++i) System.out.println(i + " - " + solve(i));
        // System.out.println(44628 + 44726 >> 1);
        // for (int i = 44677; i <= 44687; ++i) System.out.println(i + " - " + solve(i));
        // System.out.println(44677 + 44726 >> 1);
        // for (int i = 44701; i <= 44711; ++i) System.out.println(i + " - " + solve(i));
        // System.out.println(44701 + 44726 >> 1);
        // for (int i = 44713; i <= 44733; ++i) System.out.println(i + " - " + solve(i)); // 44723 overflow
    }
}
