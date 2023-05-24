import java.util.*;
import java.io.*;

public class _天干地支 {
    static String[] TG = {"", "jia", "yi", "bing", "ding", "wu", "ji", "geng", "xin", "ren", "gui"};
    static String[] DZ = {"", "zi", "chou", "yin", "mao", "chen", "si", "wu", "wei", "shen", "you", "xu", "hai"};

    public static void main(String[] args) throws IOException {
        int tg = 7, dz = 1;
        int x = 2020 % 60;
        while (x-- > 0) {
            if (--tg == 0) tg = 10;
            if (--dz == 0) dz = 12;
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        n %= 60;
        while (n-- > 0) {
            if (++tg > 10) tg = 1;
            if (++dz > 12) dz = 1;
        }
        System.out.println(TG[tg] + DZ[dz]);
    }
}
