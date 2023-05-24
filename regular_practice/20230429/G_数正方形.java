import java.util.*;
import java.io.*;

public class G_数正方形 {
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long ans = 0L;
        for (int i = 1; i <= n; ++i) {
            ans = (ans + (i * (n - i) % MOD * (n - i) % MOD)) % MOD;
        }
        System.out.println(ans);
    }
}
