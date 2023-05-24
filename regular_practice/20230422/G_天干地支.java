import java.util.*;
import java.io.*;

public class G_天干地支 {
    static String[] t = {"jia", "yi", "bing", "ding", "wu", "ji", "geng", "xin", "ren", "gui"};
    static String[] d = {"zi", "chou", "yin", "mao", "chen", "si", "wu", "wei", "shen", "you", "xu", "hai"};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        // int i = 6, j = 0;
        int i = 6, j = 8;
        // while (d-- > 0) {
        //     if (--i < 0) i = 9;
        //     if (--j < 0) j = 11;
        // }
        y %= 60;
        while (y-- > 0) {
            if (++i > 9) i = 0;
            if (++j > 11) j = 0;
        }
        System.out.println(t[i] + d[j]);
    }
}
