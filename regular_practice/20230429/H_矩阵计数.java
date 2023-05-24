import java.util.*;
import java.io.*;

public class H_矩阵计数 {
    static int n, m;
    static char[][] g;
    static int ans = 0;

    static boolean check() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j + 2 < m; ++j) {
                boolean flag = true;
                for (int k = j; k < j + 3; ++k) {
                    if (g[i][k] != 'X') flag = false;
                }
                if (flag) return false;
            }
        }
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i + 2 < n; ++i) {
                boolean flag = true;
                for (int k = i; k < i + 3; ++k) {
                    if (g[k][j] == 'O') flag = false;
                }
                if (flag) return false;
            }
        }
        return true;
    }

    static void dfs(int pos) {
        if (pos == n * m) {
            if (check()) ++ans;
            return;
        }
        int x = pos / m, y = pos % m;
        g[x][y] = 'O';
        dfs(pos + 1);
        g[x][y] = 'X';
        dfs(pos + 1);
    }

    public static void main(String[] args) throws IOException {
        // for (int i = 1; i <= 5; ++i) {
        //     System.out.print("{");
        //     for (int j = 1; j <= 5; ++j) {
        //         if (j > 1) System.out.print(", ");
        //         n = i; m = j;
        //         ans = 0;
        //         g = new char[n][m];
        //         dfs(0);
        //         System.out.print(ans);
        //     }
        //     System.out.println("},");
        // }
        Scanner in = new Scanner(System.in);
        n = in.nextInt() - 1; m = in.nextInt() - 1;
        int[][] ANS = {{2, 4, 7, 13, 24},
            {4, 16, 49, 169, 576},
            {7, 49, 265, 1573, 9253},
            {13, 169, 1573, 16561, 172197},
            {24, 576, 9253, 172197, 3157010}};
        System.out.println(ANS[n][m]);
    }
}
