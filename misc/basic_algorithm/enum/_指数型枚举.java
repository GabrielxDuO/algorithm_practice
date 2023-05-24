import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class _指数型枚举 {
    static int N;
    static List<Integer> chosen = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        dfs(1);
    }

    static void dfs(int x) {
        // 到达边界: 选到了比N大的数
        if (x == N + 1) {
            boolean flag = true;
            for (int num : chosen) {
                if (flag) flag = false;
                else System.out.print(" ");
                System.out.print(num);
            }
            System.out.print("\n");
            return;
        }

        // 不选择 x
        dfs(x + 1);
        // 选择 x
        chosen.add(x);
        dfs(x + 1);
        // 回溯
        chosen.remove(chosen.size() - 1);
    }
}
