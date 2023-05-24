import java.util.*;
import java.io.*;

public class _平方和 {
    public static void main(String[] args) throws IOException {
        long sum = 0;
        outer: for (int x = 1; x <= 2019; ++x) {
            int tmp = x;
            while (tmp > 0) {
                int d = tmp % 10;
                if (d == 2 || d == 0 || d == 1 || d == 9) {
                    sum += x * x;
                    continue outer;
                }
                tmp /= 10;
            }
        }
        System.out.println(sum);
    }
}
