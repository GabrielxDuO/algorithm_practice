import java.util.*;
import java.io.*;

public class _06找出落单的两个数 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        int[] nums = new int[N];
        int totXor = 0;
        for (int i = 0; i < N; ++i) {
            in.nextToken();
            int num = (int) in.nval;
            totXor ^= num;
            nums[i] = num;
        }
        int mask = totXor - (totXor & (totXor - 1));
        int a = 0;
        for (int num : nums) {
            if ((num & mask) != 0) a ^= num;
        }
        System.out.println(a);
        System.out.println(totXor ^ a);

    }
}
