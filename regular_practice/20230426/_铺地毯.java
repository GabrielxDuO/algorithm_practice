import java.util.*;
import java.io.*;

public class _铺地毯 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[][] carpets = new int[n + 1][4];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); carpets[i][0] = (int) in.nval;
            in.nextToken(); carpets[i][1] = (int) in.nval;
            in.nextToken(); carpets[i][2] = (int) in.nval + carpets[i][0];
            in.nextToken(); carpets[i][3] = (int) in.nval + carpets[i][1];
        }
        in.nextToken(); int x = (int) in.nval;
        in.nextToken(); int y = (int) in.nval;
        for (int i = n; i >= 1; --i) {
            int x1 = carpets[i][0], y1 = carpets[i][1], x2 = carpets[i][2], y2 = carpets[i][3];
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}