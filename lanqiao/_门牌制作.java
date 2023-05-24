import java.util.*;
import java.io.*;

public class _门牌制作 {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        for (int i = 1; i <= 2020; ++i) {
            int x = i;
            while (x > 0) {
                if (x % 10 == 2) ++cnt;
                x /= 10;
            }
        }
        System.out.println(cnt);
    }
}
