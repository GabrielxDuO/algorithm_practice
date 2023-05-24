import java.util.*;
import java.io.*;

public class _时间显示 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Long ts = in.nextLong();
        ts /= 1000;
        System.out.printf("%02d:%02d:%02d\n", ts / 3600 % 24, ts / 60 % 60, ts % 60);
    }
}
