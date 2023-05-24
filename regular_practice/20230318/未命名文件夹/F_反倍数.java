import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int cnt = 0;
        for (int x = 1; x <= n; ++x) {
            if (x % a != 0 && x % b != 0 && x % c != 0) ++cnt;
        }
        System.out.println(cnt);
    }
}
