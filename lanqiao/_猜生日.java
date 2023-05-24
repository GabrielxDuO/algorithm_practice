import java.util.*;
import java.io.*;

public class _猜生日 {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        int yy = 1912, mm = 3, dd = 12;
        // while (true) {
        //     ++dd;
        //     if (mm != 2 && dd > M[mm]) {
        //         dd = 1;
        //         ++mm;
        //     }
        //     if (mm == 2) {
        //         int o = (yy % 4 == 0 && yy % 100 != 0 && yy % 400 == 0) ? 1 : 0;
        //         if (dd > M[mm] + o) {
        //             dd = 1;
        //             ++mm;
        //         }
        //     }
        //     if (mm > 12) {
        //         mm = 1;
        //         ++yy;
        //     }
        //     if (mm == 6) {
        //         int dt = yy * 10000 + mm * 100 + dd;
        //         // System.out.println(dt);
        //         if (dt % 2012 == 0 && dt % 3 == 0 && dt % 12 == 0) {
        //             System.out.println(dt);
        //         }
        //     }
        // }
        System.out.println(19550604);
    }
}
