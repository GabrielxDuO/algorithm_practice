#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

const int N = 1e4 + 10;
int n, k;
int h[N], e[N], ne[N], idx;
bool has_p[N];
int root;
int tmp[N];
int prevs[N];
int fst;
vector<int> ans;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int bfs(int u) {
    queue<int> que;
    que.push(u);
    int step = 0;
    prevs[u] = -1;
    while (!que.empty()) {
        fst = -1;
        int sz = que.size();
        while (sz--) {
            u = que.front(); que.pop();
            if (fst == -1) fst = u;
            for (int i = h[u]; ~i; i = ne[i]) {
                int v = e[i];
                prevs[v] = u;
                que.push(v);
            }
        }
        ++step;
    }
    for (u = fst; ~u; u = prevs[u]) ans.push_back(u);
    return step;
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int u = 0; u < n; ++u) {
        scanf("%d", &k);
        for (int i = 0; i < k; ++i) {
            scanf("%d", &tmp[i]);
            has_p[tmp[i]] = true;
        }
        sort(tmp, tmp + k, [](const int& a, const int& b) { return a > b; });
        for (int i = 0; i < k; ++i) add(u, tmp[i]);
    }
    for (int u = 0; u < n; ++u) {
        if (!has_p[u]) {
            root = u;
            break;
        }
    }
    int dep = bfs(root);
    printf("%d\n", dep);
    for (auto it = ans.rbegin(); it != ans.rend(); ++it) {
        if (it != ans.rbegin()) printf(" ");
        printf("%d", *it);
    }

    return 0;
}