import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _小B的宿舍 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        int max = 0;
        while (T-- > 0) {
            System.out.println("max: " + max);
            in.nextToken();
            int N = (int) in.nval;
            int[] nums = new int[210];
            // int[] diffs = new int[210];
            while (N-- > 0) {
                in.nextToken();
                int s = (int) in.nval;
                in.nextToken();
                int t = (int) in.nval;
                s = (s - 1) >> 1;
                t = (t - 1) >> 1;
                if (s > t) {
                    int tmp = s;
                    s = t;
                    t = tmp;
                }
                // ++diffs[s];
                // --diffs[t + 1];
                for (; s <= t; ++s) max = Math.max(max, ++nums[s]);
            }
            // for ()
            if ((max & 1) != 0) max = max / 2 + 1;
            else max /= 2;
            System.out.println("res: " + (max * 10));
        }
    }
}
