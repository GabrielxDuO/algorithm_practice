#include <cstdio>
#include <cstring>
#include <unordered_set>

using namespace std;

const int N = 510, M = N * N * 2;
int V, E, K, n;
int color[N];
int h[N], e[M], ne[M], idx;
bool vis[N];
unordered_set<int> st;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool dfs(int u) {
    int& c = color[u];
    vis[u] = true;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (color[v] == c) return false;
        if (!vis[v] && !dfs(v)) return false;
    }
    return true;
}

int main() {
    scanf("%d%d%d", &V, &E, &K);
    memset(h, -1, sizeof(h));
    while (E--) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(a, b), add(b, a);
    }
    scanf("%d", &n);
    while (n--) {
        st.clear();
        for (int i = 1; i <= V; ++i) {
            scanf("%d", &color[i]);
            st.insert(color[i]);
        }
        if (st.size() != K) {
            puts("No");
            continue;
        }
        memset(vis, false, sizeof(vis));
        for (int u = 1; u <= V; ++u) {
            if (!dfs(u)) {
                puts("No");
                goto out;
            }
        }
        puts("Yes");
        out:;
    }

    return 0;
}