import java.util.*;
import java.io.*;

public class _D {
    public static void main(String[] args) throws IOException {
        int x = 2;
        outer: for (int cnt = 0; cnt < 2019; ++x) {
            for (int i = 2; i * i <= x; ++i) {
                if (x % i == 0) continue outer;
            }
            if (++cnt == 2019) System.out.println(x);
        }
    }
}
