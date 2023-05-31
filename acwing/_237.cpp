#include <cstdio>
#include <unordered_map>
#include <vector>

#define fst first
#define sec second

using namespace std;

typedef pair<int, int> PII;

const int N = 2e5 + 10;
int t, n;
int roots[N];
int idx;
unordered_map<int, int> mp;
vector<PII> eqs;
vector<PII> nes;

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &n);
        for (int i = 1; i <= n * 2; ++i) roots[i] = i;
        mp.clear();
        eqs.clear();
        nes.clear();
        idx = 0;
        for (int a = 0; a < n; ++a) {
            int i, j, k;
            scanf("%d%d%d", &i, &j, &k);
            // 离散化
            if (mp.find(i) == mp.end()) mp[i] = ++idx;
            if (mp.find(j) == mp.end()) mp[j] = ++idx;
            i = mp[i], j = mp[j];
            if (k) eqs.push_back({i, j});
            else nes.push_back({i, j});
        }
        // 合并所有相等条件
        for (PII& eq : eqs) {
            int i = eq.fst, j = eq.sec;
            join(i, j);
        }
        // 检查所有不等条件
        for (PII& ne : nes) {
            int i = ne.fst, j = ne.sec;
            if (find(i) == find(j)) {
                puts("NO");
                goto out;
            }
        }
        puts("YES");
        out:;
    }

    return 0;
}