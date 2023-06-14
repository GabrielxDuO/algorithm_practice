#include <cstdio>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

const int N = 1010, M = 10010;
int n;
int roots[M], sizes[M];
unordered_set<int> ids;

struct Info {
    int cnt, area, size, mn;
    double avg_cnt, avg_area;

    bool operator<(const Info& o) const {
        return avg_area == o.avg_area ? mn < o.mn : avg_area > o.avg_area;
    }
};
unordered_map<int, Info> infos;

int find(int x) {
    return x == roots[x] ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i < M; ++i) roots[i] = i;
    for (int i = 0; i < n; ++i) {
        int id, fa, mo, k, t;
        scanf("%d%d%d%d", &id, &fa, &mo, &k);
        ids.insert(id);
        infos[id].mn = id;
        if (~fa) join(id, fa), ids.insert(fa), infos[fa].mn = fa;
        if (~mo) join(id, mo), ids.insert(mo), infos[mo].mn = mo;
        while (k--) {
            int kid; scanf("%d", &kid);
            ids.insert(kid);
            infos[kid].mn = kid;
            join(id, kid);
        }
        scanf("%d%d", &infos[id].cnt, &infos[id].area);
    }
    vector<int> vec;
    for (auto& id : ids) {
        int root = find(id);
        if (root == id) vec.push_back(id);
        else {
            infos[root].cnt += infos[id].cnt;
            infos[root].area += infos[id].area;
        }
        infos[root].mn = min(infos[root].mn, id);
        ++infos[root].size;
    }
    vector<Info> ans;
    for (auto& id : vec) {
        Info& curr = infos[id];
        curr.avg_area = curr.area * 1.0 / curr.size;
        curr.avg_cnt = curr.cnt * 1.0 / curr.size;
        ans.push_back(curr);
    }
    printf("%d\n", ans.size());
    sort(ans.begin(), ans.end());
    for (auto& u : ans) {
        printf("%04d %d %.3lf %.3lf\n", u.mn, u.size, u.avg_cnt, u.avg_area);
    }

    return 0;
}