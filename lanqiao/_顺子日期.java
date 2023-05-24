import java.util.*;
import java.io.*;

public class _顺子日期 {
    static final int[] M = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        int mm = 1, dd = 1, cnt = 0;
        while (true) {
            if (mm / 10 + 1 == mm % 10 && mm % 10 + 1 == dd / 10 ||
                mm % 10 + 1 == dd / 10 && dd / 10 + 1 == dd % 10) ++cnt;
            if (mm == 12 && dd == 31) break;
            ++dd;
            if (dd > M[mm]) {
                dd = 1;
                ++mm;
            }
        }
        System.out.println(cnt);
    }
}
