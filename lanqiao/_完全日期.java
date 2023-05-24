import java.util.*;
import java.io.*;

public class _完全日期 {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        // int yy = 2001, mm = 1, dd = 1;
        // int ty = 2021, tm = 12, td = 31;
        // int cnt = 0;
        // while (true) {
        //     int dt = yy * 10000 + mm * 100 + dd;
        //     int sum = 0;
        //     while (dt > 0) {
        //         sum += dt % 10;
        //         dt /= 10;
        //     }
        //     if (sum == (int) Math.pow((int) Math.sqrt(sum), 2)) ++cnt;
        //     if (yy == ty && mm == tm && dd == td) break;
        //     ++dd;
        //     if (mm != 2 && dd > M[mm]) {
        //         dd = 1;
        //         ++mm;
        //     }
        //     if (mm == 2) {
        //         int o = yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0 ? 1 : 0;
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
        // System.out.println(cnt); // 977
        System.out.println(977);
    }
}
