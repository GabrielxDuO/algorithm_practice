import java.util.*;
import java.io.*;

public class _E {
    public static void main(String[] args) {
        int sum = 0;
        for (int x = 1; x <= 2019; ++x) {
            int n = x;
            while (n > 0) {
                int d = n % 10;
                if (d == 2 || d == 0 || d == 1 || d == 9) {
                    sum += x;
                    break;
                }
                n /= 10;
            }
        }
        System.out.println(sum);
    }
}
