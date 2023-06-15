import java.io.*;
import java.util.*;

public class _012 {
    static final int N = 1010;
    static int n, m;
    static int[] heap = new int[N];
    static Map<Integer, Integer> mp = new HashMap<>();

    static void up(int u) {
        int p = u >> 1;
        if (p > 0 && heap[p] > heap[u]) {
            int temp = heap[p];
            heap[p] = heap[u];
            heap[u] = temp;
            up(p);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); heap[i] = (int) in.nval;
        }
        // 这题只能O(NlogN)一个一个模拟向上更新 线性向下更新做法建出来的堆会出错
        for (int i = 1; i <= n; ++i) up(i);
        for (int i = 1; i <= n; ++i) mp.put(heap[i], i);
        StringBuilder ans = new StringBuilder();
        while (m-- > 0) {
            in.nextToken(); int x = (int) in.nval;
            in.nextToken(); String s = in.sval; // 遇到的第一个单词
            if (s.charAt(0) == 'a') {
                // 第一个单词是 and 进入兄弟节点判断
                in.nextToken(); int y = (int) in.nval;
                int ix = mp.get(x);
                int iy = mp.get(y);
                // siblings
                ans.append((ix >> 1) == (iy >> 1) ? "T" : "F").append('\n');
                in.nextToken(); // 跳过结尾的两个单词 are siblings 防止影响下一条语句的判断
                in.nextToken();
            } else {
                in.nextToken(); s = in.sval; // 遇到的第二个单词
                // 第二个单词是 a 进入子父节点判断
                if (s.charAt(0) == 'a') {
                    in.nextToken(); // 跳过中间的两个单词 child of
                    in.nextToken();
                    in.nextToken(); int y = (int) in.nval;
                    int ix = mp.get(x);
                    int iy = mp.get(y);
                    // child
                    ans.append((ix >> 1) == iy ? "T" : "F").append('\n');
                } else {
                    in.nextToken(); s = in.sval; // 遇到的第二个单词
                    // 第三个单词是 root 进入根节点判断
                    if (s.charAt(0) == 'r') {
                        // root
                        ans.append(mp.get(x) == 1 ? "T" : "F").append('\n');
                    } else {
                        // 否则第三个单词是 parent 进入父子节点判断
                        in.nextToken(); // 跳过中间的一个单词 of
                        in.nextToken(); int y = (int) in.nval;
                        int ix = mp.get(x);
                        int iy = mp.get(y);
                        // parent
                        ans.append(ix == (iy >> 1) ? "T" : "F").append('\n');
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
