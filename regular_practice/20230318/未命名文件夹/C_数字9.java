import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        for (int i = 1; i <= 2019; ++i) {
            int x = i;
            while (x > 0) {
                if (x % 10 == 9) {
                    ++cnt;
                    break;
                }
                x /= 10;
            }
        }
        System.out.println(cnt);
    }
}
