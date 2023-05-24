import java.util.*;
import java.io.*;

public class _倍数 {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        for (int i = 1; i <= 2020; ++i) {
            if (i % 4 == 0 && i % 6 == 0) ++cnt;
        }
        System.out.println(cnt);
    }
}
