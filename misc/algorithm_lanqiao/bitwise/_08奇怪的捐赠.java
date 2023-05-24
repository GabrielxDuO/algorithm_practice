import java.util.*;
import java.io.*;

public class _08奇怪的捐赠 {
    public static void main(String[] args) {
        int n = 1000000;
        int cnt = 0;
        while (n != 0) {
            cnt += n % 7;
            n /= 7;
        }
        System.out.println(cnt);
    }
}
