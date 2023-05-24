import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _大学里的树木要维护_前缀和 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;
        int[] prefixSums = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            in.nextToken();
            prefixSums[i] = prefixSums[i - 1] + (int) in.nval;
        }
        while (M-- > 0) {
            in.nextToken();
            int left = (int) in.nval;
            in.nextToken();
            int right = (int) in.nval;
            System.out.println(prefixSums[right] - prefixSums[left - 1]);
        }
    }
}
