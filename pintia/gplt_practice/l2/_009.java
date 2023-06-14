import java.util.*;

public class _009 {
    static class Info implements Comparable<Info> {
        int id, cnt, balance;

        @Override
        public int compareTo(Info o) {
            if (balance != o.balance) return Integer.compare(o.balance, balance);
            if (cnt != o.cnt) return Integer.compare(o.cnt, cnt);
            return Integer.compare(id, o.id);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Info[] infos = new Info[n + 1];
        for (int i = 1; i <= n; ++i) {
            infos[i] = new Info();
            infos[i].id = i;
        }
        for (int i = 1; i <= n; ++i) {
            int k = scanner.nextInt();
            while (k-- > 0) {
                int id = scanner.nextInt();
                int p = scanner.nextInt();
                ++infos[id].cnt;
                infos[id].balance += p;
                infos[i].balance -= p;
            }
        }
        Arrays.sort(infos, 1, n + 1);
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            ans.append(String.format("%d %.2f\n", infos[i].id, infos[i].balance / 100.0));
        }
        System.out.print(ans);
    }
}
