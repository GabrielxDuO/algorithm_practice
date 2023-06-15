#include <cstdio>
#include <vector>
#include <string>

using namespace std;

const int N = 510;
int n, m, k;
vector<int> conn[N];
int attacks[N];
bool lost[N];
int roots[N];
int group;
vector<string> ans;

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    p = find(p), q = find(q);
    if (p == q) return;
    roots[p] = q;
    --group;
}

int main() {
    scanf("%d%d", &n, &m);
    while (m-- > 0) {
        int a, b;
        scanf("%d%d", &a, &b);
        conn[a].push_back(b);
        conn[b].push_back(a);
    }
    scanf("%d", &k);
    if (k == n) ans.push_back("Game Over.");
    for (int i = 0; i < k; ++i) {
        scanf("%d", &attacks[i]);
        lost[attacks[i]] = true;
    }
    for (int i = 0; i < n; ++i) roots[i] = i;
    group = n;
    for (int u = 0; u < n; ++u) {
        if (lost[u]) continue;
        for (auto& v : conn[u]) {
            if (!lost[v]) join(u, v);
        }
    }
    int prev = group;
    for (int i = k - 1; i >= 0; --i) {
        int u = attacks[i];
        lost[u] = false;
        for (auto& v : conn[u]) {
            if (!lost[v]) join(u, v);
        }
        if (prev - group < 2) ans.push_back("City " + to_string(u) + " is lost.");
        else ans.push_back("Red Alert: City " + to_string(u) + " is lost!");
        prev = group;
    }
    for (int i = ans.size() - 1; i >= 0; --i) {
        printf("%s\n", ans[i].c_str());
    }

    return 0;
}