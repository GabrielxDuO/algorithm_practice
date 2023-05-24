import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _大学里的树木要打药_差分 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;
        int[] diffs = new int[N + 2];
        while (M-- > 0) {
            in.nextToken();
            int left = (int) in.nval;
            in.nextToken();
            int right = (int) in.nval;
            in.nextToken();
            int money = (int) in.nval;
            diffs[left + 1] += money;
            diffs[right + 2] -= money;
        }
        int total = 0;
        for (int i = 1; i < N; ++i) {
            total += (diffs[i] += diffs[i - 1]);
        }
        System.out.println(total);
    }
}
