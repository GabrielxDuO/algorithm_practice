import java.util.*;
import java.io.*;

public class H_螺旋矩阵 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] g = new int[n][m];
        int x = 0, xs = 0, xe = n - 1, ys = 0, ye = m - 1;
        while (true) {
            if (ys > ye) break;
            for (int i = ys; i <= ye; ++i) g[xs][i] = ++x;
            ++xs;
            if (xs > xe) break;
            for (int i = xs; i <= xe; ++i) g[i][ye] = ++x;
            --ye;
            if (ye < ys) break;
            for (int i = ye; i >= ys; --i) g[xe][i] = ++x;
            --xe;
            if (xe < xs) break;
            for (int i = xe; i >= xs; --i) g[i][ys] = ++x;
            ++ys;
        }
        int r = in.nextInt(), c = in.nextInt();
        System.out.println(g[r - 1][c - 1]);
    }
}
