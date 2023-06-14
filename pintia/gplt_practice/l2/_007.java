import java.io.*;
import java.util.*;

public class _007 {
    static class Info implements Comparable<Info> {
        int cnt = 0, area = 0, size = 0, mn = 0;
        double avg_cnt, avg_area;

        @Override
        public int compareTo(Info o) {
            return avg_area == o.avg_area ? Integer.compare(mn, o.mn) : Double.compare(o.avg_area, avg_area);
        }
    }

    static final int N = 1010, M = 10010;
    static int n;
    static int[] roots = new int[M];
    static int[] sizes = new int[M];
    static Set<Integer> ids = new HashSet<>();
    static Map<Integer, Info> infos = new HashMap<>();

    static int find(int x) {
        return x == roots[x] ? x : (roots[x] = find(roots[x]));
    }

    static void join(int p, int q) {
        roots[find(p)] = find(q);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        for (int i = 1; i < M; ++i) roots[i] = i;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int id = (int) in.nval;
            in.nextToken(); int fa = (int) in.nval;
            in.nextToken(); int mo = (int) in.nval;
            in.nextToken(); int k = (int) in.nval;
            ids.add(id);
            if (!infos.containsKey(id)) infos.put(id, new Info());
            infos.get(id).mn = id;
            if (fa != -1) {
                join(id, fa);
                ids.add(fa);
                if (!infos.containsKey(fa)) infos.put(fa, new Info());
                infos.get(fa).mn = fa;
            }
            if (mo != -1) {
                join(id, mo);
                ids.add(mo);
                if (!infos.containsKey(mo)) infos.put(mo, new Info());
                infos.get(mo).mn = mo;
            }
            while (k-- > 0) {
                in.nextToken();
                int kid = (int) in.nval; ids.add(kid);
                if (!infos.containsKey(kid)) infos.put(kid, new Info());
                infos.get(kid).mn = kid;
                join(id, kid);
            }
            in.nextToken(); infos.get(id).cnt = (int) in.nval;
            in.nextToken(); infos.get(id).area = (int) in.nval;
        }
        List<Integer> lst = new ArrayList<>();
        for (int id : ids) {
            int root = find(id);
            if (root == id) {
                lst.add(id);
            } else {
                infos.get(root).cnt += infos.get(id).cnt;
                infos.get(root).area += infos.get(id).area;
            }
            infos.get(root).mn = Math.min(infos.get(root).mn, id);
            ++infos.get(root).size;
        }
        List<Info> ans = new ArrayList<>();
        for (int id : lst) {
            Info curr = infos.get(id);
            curr.avg_area = curr.area * 1.0 / curr.size;
            curr.avg_cnt = curr.cnt * 1.0 / curr.size;
            ans.add(curr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        Collections.sort(ans);
        for (Info u : ans) {
            sb.append(String.format("%04d %d %.3f %.3f\n", u.mn, u.size, u.avg_cnt, u.avg_area));
        }
        System.out.print(sb);
    }
}
