import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _小B的宿舍_贪心_差分 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        int max = 0;
        while (T-- > 0) {
            in.nextToken();
            int N = (int) in.nval;
            int[] diffs = new int[210];
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
                ++diffs[s];
                --diffs[t + 1];
            }
            int num = 0;
            for (int i = 0; i < 210; ++i) {
                num += diffs[i];
                max = Math.max(max, num);
            }
            if ((max & 1) != 0) max = max / 2 + 1;
            else max /= 2;
            System.out.println(max * 10);
        }
    }
}
