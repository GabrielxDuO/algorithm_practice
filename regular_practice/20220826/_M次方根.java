import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _M次方根 {
    static final double eps = 1e-9;
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;
        double l = 0.0, r = N;
        while (r - l > eps) {
            double c = (l + r) / 2;
            double product = 1.0;
            for (int i = 0; i < M; ++i) product *= c;
            if (product >= N) r = c;
            else l = c;
        }
        System.out.printf("%.7f", l);
    }
}
