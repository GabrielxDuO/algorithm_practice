import java.util.*;
import java.io.*;

public class Main {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int dt = in.nextInt();
        int yy = dt / 10000, mm = dt / 100 % 100, dd = dt % 100;
        int ans1 = 0, ans2 = 0;
        while (true) {
            ++dd;
            if (mm != 2 && dd > M[mm]) {
                dd = 1;
                ++mm;
            }
            if (mm == 2) {
                int o = (yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0) ? 1 : 0;
                if (dd > M[mm] + o) {
                    dd = 1;
                    ++mm;
                }
            }
            if (mm > 12) {
                mm = 1;
                ++yy;
            }
            int d1 = yy / 1000, d2 = yy / 100 % 10, d3 = yy / 10 % 10, d4 = yy % 10;
            int d5 = mm / 10, d6 = mm % 10, d7 = dd / 10, d8 = dd % 10;
            if (d1 == d8 && d2 == d7 && d3 == d6 && d4 == d5) {
                dt = yy * 10000 + mm * 100 + dd;
                if (ans1 == 0) ans1 = dt;
                if (d1 != d2 && d1 == d3 && d2 == d4) {
                    ans2 = dt;
                    break;
                }
            }
        }
        System.out.println(ans1 + "\n" + ans2);
    }
}
