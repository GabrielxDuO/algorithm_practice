#include <cstdio>
#include <cstring>
#include <unordered_set>
#include <unordered_map>

using namespace std;

const int N = 35;
int t, n;
int w[N];
int cnts[N][2];
unordered_map<int, unordered_set<int>> mp;

void solve() {
    scanf("%d", &n);
    getchar();
    for (int i = 1; i <= n; ++i) w[i] = getchar() - '0';
    mp.clear();
    for (int i = 0; i < n - 1; ++i) {
        int u, v;
        scanf("%d%d", &u, &v);
        if (mp[u].find(v) != mp[u].end()) continue;
        mp[u].insert(v), mp[v].insert(u);
    }
    for (int u = 1; u <= n; ++u) {
        int cnt = 1;
        for (auto& v : mp[u]) {
            if (w[v] == w[u])
                if (++cnt >= 3) {
                    puts("NO");
                    return;
                }
        }
    }
    puts("YES");
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}