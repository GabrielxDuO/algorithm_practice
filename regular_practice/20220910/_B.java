import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _B {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        long max = N;
        for (int i = 3; i <= N; ++i) {
            long n = i;
            while (n != 1) {
                if ((n & 1) == 0) n /= 2;
                else n = n * 3 + 1;
                max = Math.max(max, n);
            }
        }
        System.out.println(max);
    }
}
