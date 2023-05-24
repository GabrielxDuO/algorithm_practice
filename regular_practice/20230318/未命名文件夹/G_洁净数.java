import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = n;
        for (int i = 1; i <= n; ++i) {
            int x = i;
            while (x > 0) {
                if (x % 10 == 2) {
                    --cnt;
                    break;
                }
                x /= 10;
            }
        }
        System.out.println(cnt);
    }
}
