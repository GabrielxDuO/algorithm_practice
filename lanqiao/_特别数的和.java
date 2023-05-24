import java.util.*;
import java.io.*;

public class _特别数的和 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            int x = i;
            while (x > 0) {
                if (x % 10 == 2 || x % 10 == 0 || x % 10 == 1 || x % 10 == 9) {
                    sum += i;
                    break;
                }
                x /= 10;
            }
        }
        System.out.println(sum);
    }
}
