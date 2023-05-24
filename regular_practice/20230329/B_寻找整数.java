import java.util.*;
import java.io.*;

public class B_寻找整数 {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        int l = lcm(11, 17);
        int[] mods = {-1, -1, 1, 2, 1, 4, 5, 4, 1, 2, 9, 0, 5, 10,
            11, 14, 9, 0, 11, 18, 9, 11, 11, 15, 17, 9,
            23, 20, 25, 16, 29, 27, 25, 11, 17, 4, 29, 22,
            37, 23, 9, 1, 11, 11, 33, 29, 15, 5, 41, 46};
        // outer: for (long i = l; i < 1e17; i += l) {
        //     for (int j = 2; j <= 20; ++j) {
        //         if (i % j != mods[j]) continue outer;
        //     }
        //     System.out.println(i);
        // } // 88209209 321001769 - = 232792560
        // outer: for (long i = 88209209; i < 1e17; i += 232792560) {
        //     for (int j = 21; j <= 49; ++j) {
        //         if (i % j != mods[j]) continue outer;
        //     }
        //     System.out.println(i);
        // } // 2022040920220409
        System.out.println(2022040920220409L);
    }
}
