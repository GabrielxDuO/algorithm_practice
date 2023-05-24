import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class _C {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Map<Integer, int[]> map = new HashMap<>();
        for (int c = 0; c * c * 2 <= n; ++c) {
            for (int d = c; c * c + d * d <= n; ++d) {
                map.putIfAbsent(c * c + d * d, new int[]{c, d});
            }
        }
        for (int a = 0; a * a * 4 <= n; ++a) {
            for (int b = a; a * a + b * b <= n / 2; ++b) {
                int rest = n - (a * a + b * b);
                if (map.containsKey(rest)) {
                    int[] cd = map.get(rest);
                    System.out.printf("%d %d %d %d\n", a, b, cd[0], cd[1]);
                    return;
                }
            }
        }
    }
}
