import java.util.*;
import java.io.*;

public class _含2天数 {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        int yy = 1900, mm = 1, dd = 1;
        int cnt = 0;
        while (true) {
            int dt = 10000 * yy + 100 * mm + dd;
            while (dt > 0) {
                if (dt % 10 == 2) {
                    ++cnt;
                    break;
                }
                dt /= 10;
            }
            if (yy == 9999 && mm == 12 && dd == 31) break;
            ++dd;
            if (mm != 2 && dd > M[mm]) {
                ++mm;
                dd = 1;
            }
            if (mm == 2) {
                int o = (yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0) ? 1 : 0;
                if (dd > M[mm] + o) {
                    ++mm;
                    dd = 1;
                }
            }
            if (mm > 12) {
                ++yy;
                mm = 1;
            }
        }
        System.out.println(cnt);
    }
}
