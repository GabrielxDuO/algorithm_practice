import java.util.*;
import java.io.*;

public class D_完全日期 {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        // int yy = 2001, mm = 1, dd = 1;
        // int cnt = 0;
        // while (true) {
        //     int dt = yy * 10000 + mm * 100 + dd;
        //     int sum = 0;
        //     while (dt > 0) {
        //         sum += dt % 10;
        //         dt /= 10;
        //     }
        //     if (Math.pow((int) Math.sqrt(sum), 2) == sum) ++cnt;
        //     if (yy == 2021 && mm == 12 && dd == 31) break;
        //     ++dd;
        //     if (mm != 2 && dd > M[mm]) {
        //         dd = 1;
        //         ++mm;
        //     }
        //     if (mm == 2) {
        //         int o = (yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0) ? 1 : 0;
        //         if (dd > M[mm] + o) {
        //             dd = 1;
        //             ++mm;
        //         }
        //     }
        //     if (mm > 12) {
        //         mm = 1;
        //         ++yy;
        //     }
        // }
        // System.out.println(cnt);
        System.out.println(977);
    }
}
