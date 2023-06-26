#include <cstdio>
#include <vector>
#include <unordered_set>

using namespace std;

const int N = 1e4 + 10, M = N * 2;
int n, m;
vector<int> conn[N];
int roots[N];
unordered_set<int> st;

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int main() {
    scanf("%d%d", &n, &m);
    int a, b;
    while (m--) {
        scanf("%d%d", &a, &b);
        conn[a].push_back(b);
        conn[b].push_back(a);
    }
    int k, np;
    scanf("%d", &k);
    while (k--) {
        for (int i = 1; i <= n; ++i) roots[i] = i;
        scanf("%d", &np);
        st.clear();
        while (np--) {
            scanf("%d", &a);
            st.insert(a);
        }
        for (int u = 1; u <= n; ++u) {
            if (st.find(u) != st.end()) continue;
            for (int v : conn[u]) {
                if (st.find(v) == st.end()) join(u, v);
            }
        }
        for (int u = 1; u <= n; ++u) {
            if (st.find(u) != st.end()) continue;
            if (roots[u] != u) {
                puts("NO");
                goto out;
            }
        }
        puts("YES");
        out:;
    }

    return 0;
}