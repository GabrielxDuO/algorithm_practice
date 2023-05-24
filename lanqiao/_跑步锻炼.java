import java.util.*;
import java.io.*;

public class _跑步锻炼 {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        int yy = 2000, mm = 1, dd = 1, wk = 6;
        int sum = 0;
        while (true) {
            sum += (dd == 1 || wk == 1) ? 2 : 1;
            if (yy == 2020 && mm == 10 && dd == 1) break;
            ++dd; ++wk;
            if (wk > 7) wk = 1;
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
        }
        System.out.println(sum);
    }
}
