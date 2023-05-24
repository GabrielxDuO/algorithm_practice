import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class _组合型枚举 {
    static int N, M;
    static List<Integer> chosen = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        in.nextToken();
        M = (int) in.nval;
        dfs(1);
    }

    static void dfs(int x) {
        // 剪枝: 选到的数多于M个 或 剩下可选的数加上当前选到的数不够M个
        if (chosen.size() > M || chosen.size() + (N - x + 1) < M) return;
        // 到达边界: 选到了比N大的数
        if (x == N + 1) {
            boolean flag = true;
            for (int num : chosen) {
                if (flag) flag = false;
                else System.out.print(" ");
                System.out.print(num);
            }
            System.out.print("\n");
        }
        // 选择 x
        chosen.add(x);
        dfs(x + 1);
        chosen.remove(chosen.size() - 1); // 回溯
        // 不选 x
        dfs(x + 1);
    }
}
