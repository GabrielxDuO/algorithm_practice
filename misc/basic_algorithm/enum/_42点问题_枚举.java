import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _42点问题_枚举 {
    public static void main(String[] args) throws IOException {
        int[] nums = new int[6];
        for (int i = 0; i < 6; ++i) {
            char ch = Reader.next().charAt(0);
            switch(ch) {
                case 'A':
                    nums[i] = 1;
                    break;
                case 'J':
                    nums[i] = 11;
                    break;
                case 'Q':
                    nums[i] = 12;
                    break;
                case 'K':
                    nums[i] = 13;
                    break;
                default:
                    nums[i] = ch - '0';
            }
        }
        List<List<Integer>> calcs = new ArrayList<>(6);
        for (int i = 0; i < 6; ++i) calcs.add(new ArrayList<>());
        calcs.get(0).add(nums[0]);
        for (int i = 1; i < 6; ++i) {
            for (int calc : calcs.get(i - 1)) {
                calcs.get(i).add(calc + nums[i]);
                calcs.get(i).add(calc - nums[i]);
                calcs.get(i).add(calc * nums[i]);
                calcs.get(i).add(calc / nums[i]);
            }
        }
        for (int ans : calcs.get(5)) {
            if (ans == 42) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static class Reader {
        static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer in = new StringTokenizer("");

        static String next() throws IOException {
            while (!in.hasMoreTokens()) {
                in = new StringTokenizer(BR.readLine());
            }
            return in.nextToken();
        }
    
        static String nextLine() throws IOException {
            return BR.readLine();
        }
    }
}
