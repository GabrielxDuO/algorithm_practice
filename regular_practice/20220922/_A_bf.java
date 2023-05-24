import java.io.*;

public class _A_bf {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int M = (int) in.nval;
        in.nextToken();
        int N = (int) in.nval;
        int[][] images = new int[N][2];
        for (int i = 0; i < N; ++i) {
            in.nextToken();
            images[i][0] = (int) in.nval;
            in.nextToken();
            images[i][1] = (int) in.nval;
        }
        int minHeight = Integer.MAX_VALUE;
        for (int del = 0; del < N; ++del) {
            int totalHeight = 0;
            int w = 0, h = 0;
            for (int i = 0; i < N; ++i) {
                if (i == del) continue;
                int imgWidth = images[i][0], imgHeight = images[i][1];
                if (imgWidth > M - w) {
                    h = Math.max(h, (imgHeight * (M - w) + imgWidth - 1) / imgWidth);
                    w = M;
                } else {
                    h = Math.max(h, imgHeight);
                    w += imgWidth;
                }
                if (w == M) {
                    w = 0;
                    totalHeight += h;
                    h = 0;
                }
            }
            totalHeight += h;
            if (totalHeight < minHeight) minHeight = totalHeight;
        }
        System.out.println(minHeight);
    }
}
